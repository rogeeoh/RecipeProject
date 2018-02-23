package command.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.RecipeBoard;
import repository.RecipeBoardDao;

public class RecipeMainCommand implements Command{
	private int pageNo;
	final private static int NUM_RECIPE_PER_PAGE = 9;
	final private static int NUM_PAGES_PER_VIEW = 5;
	
	public RecipeMainCommand(int pageNo) {
		this.pageNo = pageNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.setAttribute("boardList", new RecipeBoardDao().getBoardList());
		
		
		RecipeBoardDao recipeDao = new RecipeBoardDao();
		int totalRecipe = recipeDao.getTotalLength();
		req.setAttribute("totalRecipe", totalRecipe);
		
		int totalPage = getTotalPage(totalRecipe);
//		int totalPageBlock = getTotalPageBlock(totalPage);
		// 1부터 시작하는 현재 페이지가 속해있는 페이지블럭의 번호를 구한다.
		int currentBlock = ((pageNo - 1) / NUM_PAGES_PER_VIEW) + 1;
		int startPage = ((currentBlock - 1) * NUM_PAGES_PER_VIEW) + 1;
		req.setAttribute("startPage", startPage);
		
		int endPage = startPage + 4;
		if(endPage > totalPage)
			endPage = totalPage;
		
		req.setAttribute("endPage", endPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("numPagesPerView", NUM_PAGES_PER_VIEW);
		
		System.out.println("start : " + (0 + (pageNo * NUM_RECIPE_PER_PAGE)));
		System.out.println("limit : " + NUM_RECIPE_PER_PAGE);
		List<RecipeBoard> boardList = recipeDao.getBoardListByLimit(totalRecipe - ((pageNo) * NUM_RECIPE_PER_PAGE), NUM_RECIPE_PER_PAGE);
		req.setAttribute("boardList", boardList);
		
		for(RecipeBoard board : boardList) {
			System.out.print(board.getRecp_no() + ",");
		}
		System.out.println();
		
		
		String url = "/WEB-INF/recipe/recipe_main.jsp";
		return url;
	}

	private int getTotalPageBlock(int totalPage) {
		if(totalPage % NUM_PAGES_PER_VIEW == 0)
			return totalPage / NUM_PAGES_PER_VIEW;
		else
			return (totalPage / NUM_PAGES_PER_VIEW) + 1;
	}

	private int getTotalPage(int totalRecipe) {
		if(totalRecipe % NUM_RECIPE_PER_PAGE == 0)
			return totalRecipe / NUM_RECIPE_PER_PAGE;
		else
			return (totalRecipe / NUM_RECIPE_PER_PAGE) + 1;
	}
}
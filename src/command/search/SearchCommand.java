package command.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.RecipeBoard;
import repository.RecipeBoardDao;

public class SearchCommand implements Command {
	private String query;
	
	public SearchCommand(String query) {
		this.query = query;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RecipeBoardDao recipeDao = new RecipeBoardDao();
		ArrayList<RecipeBoard> recipeList = recipeDao.getBoardList(query);

		req.setAttribute("recipeList", recipeList);
		
		return "/WEB-INF/search/search_list.jsp";
	}
}

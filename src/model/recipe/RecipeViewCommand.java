package model.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Command;
import model.dao.IngreDao;
import model.dao.RecipeBoardDao;

public class RecipeViewCommand implements Command{

	private Integer recpNo;
	public RecipeViewCommand(Integer recpNo) {
		this.recpNo = recpNo;
	}
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RecipeBoardDao recpBoard = new RecipeBoardDao();
		IngreDao ingre = new IngreDao();
		req.setAttribute("board", recpBoard.getBoard(recpNo));
		req.setAttribute("ingreList", ingre.getIngreList(recpNo));
		String url = "/WEB-INF/recipe/recipe_view.jsp";
		return url;
	}
}

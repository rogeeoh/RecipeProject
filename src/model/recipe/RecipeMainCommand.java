package model.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Command;
import model.dao.RecipeBoardDao;
import model.dto.RecipeBoard;

public class RecipeMainCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("boardList", new RecipeBoardDao().getBoardList());
		String url = "/WEB-INF/recipe/recipe_main.jsp";
		return url;
	}
}
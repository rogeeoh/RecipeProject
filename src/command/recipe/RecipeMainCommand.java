package command.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.RecipeBoard;
import repository.RecipeBoardDao;

public class RecipeMainCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("boardList", new RecipeBoardDao().getBoardList());
		String url = "/WEB-INF/recipe/recipe_main.jsp";
		return url;
	}
}
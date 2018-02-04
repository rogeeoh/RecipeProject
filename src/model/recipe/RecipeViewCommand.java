package model.recipe;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Command;
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
		recpBoard.getBoard(recpNo);
		String url = "/WEB-INF/recipe/recipe_view.jsp";
		
		return url;
	}
}

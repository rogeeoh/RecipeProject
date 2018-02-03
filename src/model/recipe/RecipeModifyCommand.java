package model.recipe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Command;
import model.dao.IngreDao;
import model.dao.RecipeBoardDao;
import model.dto.Ingre;
import model.dto.RecipeBoard;

public class RecipeModifyCommand implements Command{
	private Integer recpNo;
	
	public RecipeModifyCommand(Integer recpNo) {
		this.recpNo = recpNo;
	}
	
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* 만약 적합한 아이디가 아니라면 */
		if(req.getSession().getAttribute("id") == null)
			return "/WEB-INF/login/login.jsp";
		
		
		RecipeBoard recipe = new RecipeBoardDao().getBoard(recpNo);
		ArrayList<Ingre> ingreList = new IngreDao().getIngreList(recpNo);
		
		req.setAttribute("recipe", recipe);
		req.setAttribute("ingreList", ingreList);

		String url = "/WEB-INF/recipe/recipe_modify.jsp";
		return url;
	}
}

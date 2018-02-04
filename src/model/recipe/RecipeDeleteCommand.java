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

public class RecipeDeleteCommand implements Command{
	private Integer recpNo;
	
	public RecipeDeleteCommand(Integer recpNo) {
		this.recpNo = recpNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* 만약 적합한 아이디가 아니라면 */
		if(req.getSession().getAttribute("id") == null)
			return "/WEB-INF/login/login.jsp";
		/* recpNo번에 해당하는 글을 삭제하는 작업 진행 */
		
		new RecipeBoardDao().deleteBoard(recpNo);
		
		String url = "recipe";
		return url;
	}
}

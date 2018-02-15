package command.recipe;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.Command;
import command.user.LoginCommand;

public class RecipeWriteCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* 만약 적합한 아이디가 아니라면 */
		if(req.getSession().getAttribute("id") == null)
			return "/WEB-INF/login/login.jsp";
		
		String url = "/WEB-INF/recipe/recipe_upload.jsp";
		return url;
	}
}

package command.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

public class ShowOffWriteCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* 만약 적합한 아이디가 아니라면 */
		if(req.getSession().getAttribute("id") == null)
			return "/WEB-INF/login/login.jsp";
		
		return "/WEB-INF/community/showoff/showoff_upload.jsp";
	}

}

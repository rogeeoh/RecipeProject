package model.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Command;
import model.dao.MemberDao;

public class AjaxCheckIdCommand implements Command {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		boolean isUnique = new MemberDao().isUniqueEmail(email);
		
		String ret = null;
		
		if(isUnique)
			ret = "true";
		else
			ret = "false";
		
		System.out.println("ret : " + ret);
		return ret;
	}

}

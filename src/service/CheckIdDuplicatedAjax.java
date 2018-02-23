package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import repository.MemberDao;

public class CheckIdDuplicatedAjax implements Command {

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
		
		return ret;
	}

}

package command.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import repository.MemberDao;

public class AjaxCheckSessionCommand implements Command {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("id");
		
		String ret;
		if(id == null)
			ret = "false";
		else
			ret = "true";
		
		return ret;
	}

}
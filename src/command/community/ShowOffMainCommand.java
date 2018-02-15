package command.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import repository.ShowOffBoardDao;

public class ShowOffMainCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("showoffList", new ShowOffBoardDao().getShowOffList());
		String url = "/WEB-INF/community/community_main.jsp";
		return url;
	}
}

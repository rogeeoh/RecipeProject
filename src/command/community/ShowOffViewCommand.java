package command.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import repository.ShowOffBoardDao;

public class ShowOffViewCommand implements Command {
	
	private Integer showoffNo;
	
	public ShowOffViewCommand(int showoffNo) {
		this.showoffNo = showoffNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("showoff", new ShowOffBoardDao().getShowOff(showoffNo));
		return "/WEB-INF/community/showoff/showoff_view.jsp";
	}

}

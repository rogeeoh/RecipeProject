package command.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.ShowOffBoard;
import repository.ShowOffBoardDao;

public class ShowOffModifyCommand implements Command {
	private Integer showoffNo;
	
	public ShowOffModifyCommand(Integer showoffNo) {
		this.showoffNo = showoffNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/* 만약 적합한 아이디가 아니라면 */
		if(req.getSession().getAttribute("id") == null)
			return "/WEB-INF/login/login.jsp";
		
		ShowOffBoard showoff = new ShowOffBoardDao().getShowOff(showoffNo);
		req.setAttribute("showoff", showoff);
		String url = "/WEB-INF/community/showoff/showoff_modify.jsp";
		return url;
	}

}

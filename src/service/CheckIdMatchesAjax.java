package service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.RecipeBoard;
import repository.MemberDao;
import repository.RecipeBoardDao;

public class CheckIdMatchesAjax implements Command {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 만약 로그인되지 않은 상태라면 null을 반환
		Integer mem_no = (Integer)req.getSession().getAttribute("mem_no");
		if(mem_no == null)
			return "null";
		
		// 만약 운영자라면 무조건 true를 반환
		if(req.getSession().getAttribute("id").equals("admin"))
			return "true";
		
		RecipeBoard board = new RecipeBoardDao().getBoard(Integer.parseInt(req.getParameter("recp_no")));
		// 만약 현재 로그인한 사람이 글의 작성자라면 true를 리턴
		if(board.getMem_no() == mem_no)
			return "true";

		// 만약 권한이 없는 사람이라면 false를 리턴
		return "false";
	}
}

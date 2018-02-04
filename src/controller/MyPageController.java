package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		
		/* 만약 로그인되지 않은 상태에서 들어온다면 로그인 페이지로 이동 */
		String id = (String)req.getSession().getAttribute("id");
		if(id == null) {
			resp.sendRedirect("login?cmd=login");
			return;
		}
		
		/*만약 cmd가 들어오지 않는다면 이건 Main페이지로 이동*/
		if(cmd == null)
			cmd = "main";
		
		String url = null;
		switch(cmd) {
			case "main":
				url = "/WEB-INF/mypage/mypage_main.jsp";
				break;
			case "recipe":
				url = "/WEB-INF/mypage/mypage_myrecipe.jsp";
				break;
			case "post":
				url = "/WEB-INF/mypage/mypage_mypost.jsp";
				break;
			case "reply":
				url = "/WEB-INF/mypage/mypage_myreply.jsp";
				break;
		}
		
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

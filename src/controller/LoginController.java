package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("email").toLowerCase();
		String pw = req.getParameter("password");
		
		if(id.equals("admin") && pw.equals("1111")) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			System.out.println("로그인 성공!");
		}
		
		resp.sendRedirect("index.jsp");
	}
}

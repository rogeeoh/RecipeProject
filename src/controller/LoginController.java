package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import factory.LoginFactory;
import factory.RecipeFactory;

public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cmd = req.getParameter("cmd");
		if(cmd != null)
			cmd = cmd.toLowerCase();

		LoginFactory loginFactory = LoginFactory.newInstance();
		Command interfaceCmd = loginFactory.createInstance(cmd);
		String url = (String)interfaceCmd.processCommand(req, resp);
		/* 만약 로그인을 성공한 상황이라면 */
		if(url.equals("index.jsp")) {
			resp.sendRedirect(url);
			return;
		}
		
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

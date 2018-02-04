package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Command;
import model.community.ShowOffFactory;

public class ShowOffController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		
		/*만약 cmd가 들어오지 않는다면 이건 Main페이지로 이동*/
		if(cmd != null) {
			cmd = cmd.toLowerCase();
		}
		Integer showoffNo = null;
		String no = req.getParameter("no");
		if(no != null) {
			showoffNo = Integer.parseInt(no);
		}
		ShowOffFactory showoffFactory = ShowOffFactory.newInstance();
		Command iCmd = showoffFactory.createInstance(cmd, showoffNo);
		String url = (String)iCmd.processCommand(req, resp);
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

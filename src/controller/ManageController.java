package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Command;
import model.manage.ManageFactory;

public class ManageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		/* 만약 관리자권한이 없는 사용자라면 그냥 메인페이지로 돌려보낸다. */
		String id = (String)req.getSession().getAttribute("id");
		/* NullPointerException 방지 처리 */
		if(id == null) id = "";

		if(!id.equals("admin")) {
			resp.sendRedirect("index.jsp");
			return;
		}
		
		String cmd = req.getParameter("cmd");
		if(cmd != null)
			cmd = cmd.toLowerCase();
		
		RequestDispatcher view = null;
		ManageFactory mgrFactory = ManageFactory.newInstance();
		Command interfaceCmd = mgrFactory.createInstance(cmd);
		String url = (String)interfaceCmd.processCommand(req, resp);
		
		view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

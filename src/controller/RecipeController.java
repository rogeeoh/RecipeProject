package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import factory.RecipeFactory;

public class RecipeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String cmd = req.getParameter("cmd");
		if(cmd != null)
			cmd = cmd.toLowerCase();

		Integer recpNo = null;
		String no = req.getParameter("no");
		if(no != null)
			recpNo = Integer.parseInt(no);
		
		RequestDispatcher view = null;
		RecipeFactory recpFactory = RecipeFactory.newInstance();
		Command interfaceCmd = recpFactory.createInstance(cmd, recpNo);
		String url = (String)interfaceCmd.processCommand(req, resp);
				
		view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

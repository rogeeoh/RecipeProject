package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import factory.DeleteBoardFactory;

public class BoardDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String board = req.getParameter("board");
		String no = req.getParameter("no");
		
		DeleteBoardFactory factory = DeleteBoardFactory.newInstance();
		Command interfaceCmd = factory.createInstance(board, no);
		String url = (String)interfaceCmd.processCommand(req, resp);

		
		System.out.println("url : " + url);
		resp.sendRedirect(url);
	}
}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Command;
import model.ajax.AjaxFactory;
import model.recipe.RecipeFactory;

public class AjaxController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		/* 전달하는 데이터가 json임을 알려준다. */
		resp.setContentType("json");
		
		String board = req.getParameter("board");
		String command = req.getParameter("cmd");
		
		AjaxFactory ajaxFactory = AjaxFactory.newInstance();
		Command ajaxCmd = ajaxFactory.createInstance(board, command);
		String json = (String)ajaxCmd.processCommand(req, resp);
		
		PrintWriter out = resp.getWriter();
		out.println(json);
		out.close();
	}
}

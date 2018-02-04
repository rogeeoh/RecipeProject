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
		
		/* 만약 board가 parameter값이 존재하는 경우에는 무조건 admin의 권한이 필요 */
		String board = req.getParameter("board");
		String command = req.getParameter("cmd");
		
		AjaxFactory ajaxFactory = AjaxFactory.newInstance();
		Command ajaxCmd = ajaxFactory.createInstance(board, command);
		String resonseText = (String)ajaxCmd.processCommand(req, resp);
		
		PrintWriter out = resp.getWriter();
		out.println(resonseText);
		out.close();
	}
}

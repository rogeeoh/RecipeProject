package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import factory.RecipeFactory;
import factory.SearchFactory;

public class SearchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// 어떤 게시판에서 검색을 할 것인지
		// null이면 메인 검색
		String board = req.getParameter("board");
		if(board != null)
			board = board.toLowerCase();
		
		String query = req.getParameter("query");
		if(query != null)
			query = query.toLowerCase();
		

		RequestDispatcher view = null;
		SearchFactory searchFactory = SearchFactory.newInstance();
		Command interfaceCmd = searchFactory.createInstance(board, query);
		String url = (String)interfaceCmd.processCommand(req, resp);
				
		view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

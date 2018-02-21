package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import factory.FactoryPostBoard;


public class BoardPostController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String board = req.getParameter("board");
		if(board != null) {
			board = board.toLowerCase();
		}
		String no = req.getParameter("no");
		Integer boardNo = null;
		if(no != null) {
			boardNo = Integer.parseInt(no);
		}
		System.out.println("게시글번호 : " + boardNo);
		FactoryPostBoard factory = FactoryPostBoard.newInstance();
		Command interfaceCmd = factory.createInstance(board, boardNo);
		String url = (String)interfaceCmd.processCommand(req, resp);

		resp.sendRedirect(url);
	}
}

package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Command;
import model.FactoryDeleteBoard;
import model.FactoryPostBoard;


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
		
		FactoryDeleteBoard factory = FactoryDeleteBoard.newInstance();
		Command interfaceCmd = factory.createInstance(board, no);
		String url = (String)interfaceCmd.processCommand(req, resp);

		resp.sendRedirect(url);
	}
}

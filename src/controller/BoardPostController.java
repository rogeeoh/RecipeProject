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
import model.FactoryPostBoard;


public class BoardPostController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String board = req.getParameter("board");
		
		FactoryPostBoard factory = FactoryPostBoard.newInstance();
		Command interfaceCmd = factory.createInstance(board);
		String url = (String)interfaceCmd.processCommand(req, resp);

		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

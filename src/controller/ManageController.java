package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Command;
import model.FactoryPostBoard;
import model.RecipeFactory;
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

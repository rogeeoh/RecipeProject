package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RecipeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String recipeCmd = req.getParameter("cmd");
		if(recipeCmd != null)
			recipeCmd = recipeCmd.toLowerCase();
		
		String recipeNo = req.getParameter("no");
		String url = null;
		RequestDispatcher view = null;
		
		if(recipeCmd == null) {
			// 만약 localhost:8080/recipe 경로로 접근한 것이라면 메인페이지로 이동한다
			if(recipeNo == null) {
				view = req.getRequestDispatcher("/WEB-INF/recipe/recipe_main.jsp");
				view.forward(req, resp);
				return;
			}
			
			/* recipe?no=글번호 를 통해 글을 보고 싶은 거라면 */
			// DAO로 해당 글 번호에 해당하는 DTO 가져오기 (미 구현)
			Object dto = null;
			req.setAttribute("dto", dto);
			view = req.getRequestDispatcher("/WEB-INF/recipe/recipe_view.jsp");
			view.forward(req, resp);
			return;
		}
		
		
		
		switch(recipeCmd) {
			case "write":
				url = "/WEB-INF/recipe/recipe_upload.jsp";
				break;
			case "modify":
				// DAO로 해당 글 번호에 해당하는 DTO 가져오기 (미 구현)
				Object dto = null;
				req.setAttribute("dto", dto);
				url = "/WEB-INF/recipe/recipe_modify.jsp";
				break;
			case "del":
				// recipeNo에 해당하는 삭제 작업 진행
				System.out.println(recipeNo + "번째 글을 삭제했습니다.");
				url = "/WEB-INF/recipe/recipe_main.jsp";
				break;
		}
		
		
		view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

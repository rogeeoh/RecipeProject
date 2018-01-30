package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowOffController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		String boardNo = req.getParameter("no");
		
		/*만약 cmd가 들어오지 않는다면 이건 Main페이지로 이동*/
		if(cmd == null) {
			cmd = "main";
		} else {
			cmd = cmd.toLowerCase();
		}
		
		String url = null;
		
		switch(cmd) {
			case "main":
				url = "/WEB-INF/community/showoff_main.jsp";
				break;
			case "write":
				url = "/WEB-INF/community/showoff_upload.jsp";
				break;
			case "modify":
				// DAO로 해당 글 번호에 해당하는 DTO 가져오기 (미 구현)
				Object dto = null;
				req.setAttribute("dto", dto);
				url = "/WEB-INF/community/showoff_modify.jsp";
				break;
			case "del":
				// recipeNo에 해당하는 삭제 작업 진행
				System.out.println(boardNo + "번째 글을 삭제했습니다.");
				url = "/WEB-INF/community/showoff_main.jsp";
				break;
		}
		
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
	}
}

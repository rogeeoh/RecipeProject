package model.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Command;

public class LoginCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("email").toLowerCase();
		String pw = req.getParameter("password");
		String url = null;
		/* DB로부터 비밀번호를 확인하는 코드 작성 */
		if(id.equals("admin") && pw.equals("1111")) {
			session.setAttribute("id", id);
			System.out.println("로그인 성공!");
			url = "index.jsp";
		}
		else if(id.equals("user") && pw.equals("1111")) {
			session.setAttribute("id", id);
			System.out.println("로그인 성공!");
			url = "index.jsp";
		}
		/* 로그인실패를 가정 */
		else {
			System.out.println("로그인 실패: 아이디나 비밀번호를 확인해주세요");
			req.setAttribute("loginFail", "fail");
			url = "/WEB-INF/login/login.jsp";
		}
		/* DB로부터 비밀번호를 확인하는 코드 작성 종료 */
		
		/* 최종적으로 로그인을 시도한 페이지로 이동시켜주는 것이 바람직함. 일단은 index */
		
		return url;
	}
}

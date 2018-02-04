package model.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Command;

public class CreateAccountCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = null;
		if(req.getSession().getAttribute("id") != null) {
			/* 만약 로그인된 상태에서 접속을 시도하면 차단 */
			url = "index.jsp";
			return url;
		}
		
		/* 아이디 체크 후 만약 회원가입에 성공하면 알려줌 */
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		String nickName = req.getParameter("nickName");
		String birth = req.getParameter("birth");
		String tel = req.getParameter("tel");
		String gender = req.getParameter("gender");
		if(gender == null) {
			gender = "남자";
		}
		else {
			gender = "여자";
		}
		
		System.out.println("email : " + email);
		System.out.println("pw : " + pw);
		System.out.println("nickName : " + nickName);
		System.out.println("birth : " + birth);
		System.out.println("tel : " + tel);
		System.out.println("gender : " + gender);
		
		req.setAttribute("email", email);
		req.setAttribute("pw", pw);
		req.setAttribute("nickName", nickName);
		req.setAttribute("birth", birth);
		req.setAttribute("tel", tel);
		req.setAttribute("gender", gender);
		
		/* 아이디를 찾는 페이지로 이동시킨다 */
		url = "WEB-INF/login/show_register_success.jsp";
		return url;
	}
}

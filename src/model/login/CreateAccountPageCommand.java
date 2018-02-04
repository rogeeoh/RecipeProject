package model.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Command;

public class CreateAccountPageCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/* 회원가입하는 페이지로 이동하는 커맨드 */
		String url = null;
		if(req.getSession().getAttribute("id") != null) {
			/* 만약 로그인된 상태에서 접속을 시도하면 차단 */
			url = "index.jsp";
			return url;
		}
		
		/* 아이디를 찾는 페이지로 이동시킨다 */
		url = "WEB-INF/login/create_account.jsp";
		return url;
	}
}

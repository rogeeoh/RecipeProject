package command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;

public class FindPwPageCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = null;
		if(req.getSession().getAttribute("id") != null) {
			/* 만약 로그인된 상태에서 접속을 시도하면 차단 */
			return "index.jsp";
		}
		
		/* 비밀번호를 찾는 페이지로 이동시킨다 */
		url = "WEB-INF/login/find_pw.jsp";
		return url;
	}
}

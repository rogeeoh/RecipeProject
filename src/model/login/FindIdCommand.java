package model.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Command;

public class FindIdCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = null;
		if(req.getSession().getAttribute("id") != null) {
			/* 만약 로그인된 상태에서 접속을 시도하면 차단 */
			return "index.jsp";
		}
			
		String nick = req.getParameter("nick");
		String birthday = req.getParameter("birthday");

		/* DB에서 nick과 birth가 일치하는지 확인 */
		/* 만약 일치한다면 */
		if(nick.equals("admin") && birthday.equals("11/11/11")) {
			/* 아이디를 보여주는 페이지로 이동. */
			String foundId = "admin";
			req.setAttribute("foundId", foundId);
			url = "WEB-INF/login/show_found_id.jsp";
			return url;
		}
		
		/* 만약 입력한 값이 일치하지 않는다면 원래의 페이지로 다시 돌려보낸다. */
		req.setAttribute("fail", "failedFindingId");
		url = "WEB-INF/login/find_id.jsp";
		return url;
	}
}

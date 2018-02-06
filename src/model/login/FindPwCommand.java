package model.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Command;
import model.dao.MemberDao;
import model.dto.Member;

public class FindPwCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = null;
		if(req.getSession().getAttribute("id") != null) {
			/* 만약 로그인된 상태에서 접속을 시도하면 차단 */
			return "index.jsp";
		}
			
		String email = req.getParameter("email");
		String birthday = req.getParameter("birthday");

		
		Member dto = new MemberDao().findPassword(email, birthday);

		/* 만약 입력한 값이 일치하지 않는다면 원래의 페이지로 다시 돌려보낸다. */
		if(dto == null) {
			req.setAttribute("fail", "failedFindingPw");
			url = "WEB-INF/login/find_pw.jsp";
			return url;
		}
		
		/* 만약 일치한다면 */
		String foundPw = dto.getPw();
		req.setAttribute("foundPw", foundPw);
		url = "WEB-INF/login/show_found_pw.jsp";
		return url;
	}
}

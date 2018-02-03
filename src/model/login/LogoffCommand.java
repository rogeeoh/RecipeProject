package model.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Command;

public class LogoffCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		// 로그아웃 시키는 코드
		session.invalidate();
		System.out.println("로그아웃 성공");
		String url = "index.jsp";
		return url;
	}
}

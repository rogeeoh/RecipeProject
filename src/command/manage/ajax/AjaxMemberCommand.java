package command.manage.ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import command.Command;
import dbcp.DBConnectionMgr;
import model.Member;
import repository.MemberDao;

public class AjaxMemberCommand implements Command{
	private String command;
	private MemberDao memDao;
	public AjaxMemberCommand(String command) {
		this.command = command;
		memDao = new MemberDao();
	}
	
	private Member makeMemberDto(HttpServletRequest req, HttpServletResponse resp) {
		Member member = new Member();
		
		int mem_no = -1;
		/* mem_no의 parseInt에서 exception의 예외처리 */
		if(req.getParameter("mem_no") != null && !req.getParameter("mem_no").equals(""))
			mem_no = Integer.parseInt((String)req.getParameter("mem_no"));
		
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		String birth = (String)req.getParameter("birth");
		if(birth == null) birth = "";
		String gender = (String)req.getParameter("gender");
		String nick = (String)req.getParameter("nick");
		String pic_url = (String)req.getParameter("pic_url");
		
		if(mem_no != -1)
			member.setMem_no(mem_no);
		
		member.setId(id);
		member.setPw(pw);
		member.setBirth(birth);
		member.setGender(gender);
		member.setNick(nick);
		member.setPic_url(pic_url);
		
		return member;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* admin 체크 부분 */
		if(req.getSession().getAttribute("id") == null)
			return null;
		if(!req.getSession().getAttribute("id").equals("admin"))
			return null;
		
		/* 전달하는 데이터가 json임을 알려준다. */
		resp.setContentType("json");
		
		/* 넘어온 parameter를 통해 MemberDto를 만들기 위해서 req, resp를 전송해준다. */
		if(command != null) {
			Member memDto = makeMemberDto(req, resp);
			
			switch(command) {
				case "insert":
					memDao.insertMember(memDto);
					break;
				case "delete":
					memDao.deleteMember(memDto);
					break;
				case "update":
					memDao.updateMember(memDto);
					break;
			}
		}
		
		String json = new Gson().toJson(memDao.getMemberList());
		return json;
	}
}
package model.ajax;

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

import dbcp.DBConnectionMgr;
import model.Command;
import model.dao.MemberDao;
import model.dto.Member;

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
		if(req.getParameter("mem_no") != null)
			mem_no = Integer.parseInt((String)req.getParameter("mem_no"));
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		String birth = (String)req.getParameter("birth");
		if(birth.equals(""))
			birth = null;
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

		if(command != null) {
			Member memDto = makeMemberDto(req, resp);
			
			switch(command) {
				case "insert":
					insertMember(memDto);
					break;
				case "delete":
					deleteMember(memDto);
					break;
				case "update":
					updateMember(memDto);
					break;
			}
		}
		
		String json = new Gson().toJson(getMemberList());
		return json;
	}
	
	/* dao로 빼야함 */
	private ArrayList<Member> getMemberList(){
		ArrayList<Member> memberList = memDao.getMemberList();
		return memberList;
	}
	
	private void insertMember(Member memDto) {
		memDao.insertMember(memDto);
	}
	
	private void deleteMember(Member memDto) {
		memDao.deleteMember(memDto);
	} // end delete()
	
	private void updateMember(Member memDto) {
		memDao.updateMember(memDto);
	} // end update()
	
}
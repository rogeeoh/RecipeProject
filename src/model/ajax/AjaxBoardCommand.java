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
import model.dto.Member;

public class AjaxBoardCommand implements Command{
	private DBConnectionMgr pool;
	private Connection con;
	private String command;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AjaxBoardCommand(String command) {
		this.command = command;
	}
	
	private ArrayList<Member> getMemberList(){
		ArrayList<Member> memList = null;
		try {
			String sql = "SELECT * FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			memList = new ArrayList<Member>();
			
			while(rs.next()) {
				Member dto = new Member();
				dto.setMem_no(rs.getInt("mem_no"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setNick(rs.getString("nick"));
				dto.setPic_url(rs.getString("pic_url"));
				memList.add(dto);
			}
		} catch (SQLException err) {
			System.out.println("getMemberList() error : " + err);
		}
		
		return memList;
	}
	
	private void makeConnection() {
		try {
			pool = DBConnectionMgr.getInstance();
			con = pool.getConnection();
		} catch (Exception err) {
			System.out.println("DB에서 DTO 가져오는 도중 오류 발생함 " + err);
		}
	}
	
	private void endConnection() {
		try {
			if(con != null)	con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException err) {
			System.out.println("Connection Close Error" + err);
		}
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		makeConnection();
		
		if(command != null) {
			switch(command) {
				case "insert":
					insert(req, resp);
					break;
				case "delete":
					delete(req, resp);
					break;
				case "update":
					update(req, resp);
					break;
			}
		}
		
		String json = new Gson().toJson(getMemberList());
		endConnection();
		
		return json;
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) {
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		String birth = (String)req.getParameter("birth");
		if(birth.equals(""))
			birth = null;
		String gender = (String)req.getParameter("gender");
		String nick = (String)req.getParameter("nick");
		String pic_url = (String)req.getParameter("pic_url");

		try {
			String sql = "INSERT INTO member(id, pw, birth, gender, nick, pic_url)"
				+ " values (?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
		
			int cnt = 1;
			pstmt.setString(cnt++, id);
			pstmt.setString(cnt++, pw);
			pstmt.setString(cnt++, birth);
			pstmt.setString(cnt++, gender);
			pstmt.setString(cnt++, nick);
			pstmt.setString(cnt++, pic_url);
		
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("Insert 하다 프로세스 Exception 발생" + err);
		}		
	} // end insert()
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		String mem_no = req.getParameter("mem_no");
		
		try {
			String sql = "DELETE FROM member WHERE mem_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_no);
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("DELETE 하다 프로세스 Exception 발생" + err);
		}
	} // end delete()
	
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("update 실행");
		int mem_no = Integer.parseInt((String)req.getParameter("mem_no"));
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		String birth = (String)req.getParameter("birth");
		String gender = (String)req.getParameter("gender");
		String nick = (String)req.getParameter("nick");
		String pic_url = (String)req.getParameter("pic_url");
		
		try {
			String sql = "UPDATE member SET id = ?, pw = ?, birth = ?, gender = ?, nick = ?,"
					+ "pic_url = ? WHERE mem_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setString(cnt++, id);
			pstmt.setString(cnt++, pw);
			pstmt.setString(cnt++, birth);
			pstmt.setString(cnt++, gender);
			pstmt.setString(cnt++, nick);
			pstmt.setString(cnt++, pic_url);
			pstmt.setInt(cnt++, mem_no);
			
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("update 하다 프로세스 Exception 발생" + err);
		}
	} // end update()
	
}
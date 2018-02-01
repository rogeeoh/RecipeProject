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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dbcp.DBConnectionMgr;
import dto.Member;
import model.Command;

public class AjaxMemberCommand implements Command{
	private DBConnectionMgr pool;
	private Connection con;
	private String command;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AjaxMemberCommand(String command) {
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
			con.close();
			pstmt.close();
			rs.close();
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
				case "add":
					add(req, resp);
					break;
				case "del":
					del(req, resp);
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
	
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		gson.toJson(req.getParameterNames());
		
		Enumeration e = req.getParameterNames();
		Queue<String> queue = new LinkedList<>(); 
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = req.getParameter(key);
			
			queue.add(value);
			System.out.println(key + "," + value);
		}
		queue.poll();
		queue.poll();
		queue.poll();
		
		try {
			String sql = "INSERT INTO member(id, pw, birth, gender, nick, pic_url)"
					+ " values (?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			int cnt = 1;
			while(!queue.isEmpty()) {
				pstmt.setString(cnt, queue.poll());
				cnt++;
			}
			
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("Insert 하다 디짐ㅋ" + err);
		}
	} // end add()
	
	private void del(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("del method called");
		
		Gson gson = new Gson();
		gson.toJson(req.getParameterNames());
		
		Enumeration e = req.getParameterNames();
		Queue<String> queue = new LinkedList<>(); 
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = req.getParameter(key);
			
			queue.add(value);
			System.out.println(key + "," + value);
		}
		queue.poll();
		queue.poll();
		
		try {
			String sql = "DELETE FROM member WHERE mem_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, queue.poll());
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("DELETE 하다 디짐ㅋ" + err);
		}
	} // end del()
	
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		gson.toJson(req.getParameterNames());
		
		Enumeration e = req.getParameterNames();
		Queue<String> queue = new LinkedList<>(); 
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = req.getParameter(key);
			
			queue.add(value);
			System.out.println(key + "," + value);
		}
		queue.poll();
		queue.poll();
		int mem_no = Integer.parseInt(queue.poll());
		
		try {
			String sql = "UPDATE member SET id = ?, pw = ?, birth = ?, gender = ?, nick = ?,"
					+ "pic_url = ? WHERE mem_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			int cnt = 1;
			while(!queue.isEmpty()) {
				pstmt.setString(cnt, queue.poll());
				cnt++;
			}
			pstmt.setInt(cnt, mem_no);
			
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("Update 하다 디짐ㅋ" + err);
		}
	} // end update()
	
}
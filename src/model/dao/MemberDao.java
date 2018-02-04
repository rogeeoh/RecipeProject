package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.DBConnectionMgr;
import model.dto.Member;

public class MemberDao {
	private DBConnectionMgr pool;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDao() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception err) {
			System.out.println("DBConnnectionMgr.getInstance() fail" + err);
			err.printStackTrace();
		}
	}
	
	public ArrayList<Member> getMemberList(){
		/* DBConnection을 가져오기 종료 */
		ArrayList<Member> memberList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM member";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member dto = new Member();
				dto.setMem_no(rs.getInt("mem_no"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setNick(rs.getString("nick"));
				dto.setPic_url(rs.getString("pic_url"));
				memberList.add(dto);
			}
		} catch (SQLException err) {
			System.out.println("getMemberList() error : " + err);
			err.printStackTrace();
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return memberList;
	}
	
	/**
	 * 
	 * @param memDto
	 */
	
	public void insertMember(Member memDto) {
		String id = memDto.getId();
		String pw = memDto.getPw();
		String birth = memDto.getBirth();
		String gender = memDto.getGender();
		String nick = memDto.getNick();
		String pic_url = memDto.getPic_url();
		String tel = memDto.getTel();
		
		try {
			String sql = "INSERT INTO member(id, pw, birth, gender, nick, pic_url, tel)"
				+ " values (?, ?, ?, ?, ?, ?, ?)";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
		
			int cnt = 1;
			pstmt.setString(cnt++, id);
			pstmt.setString(cnt++, pw);
			pstmt.setString(cnt++, birth);
			pstmt.setString(cnt++, gender);
			pstmt.setString(cnt++, nick);
			pstmt.setString(cnt++, pic_url);
			pstmt.setString(cnt++, tel);
		
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("Insert 하다 프로세스 Exception 발생" + err);
			err.printStackTrace();
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
	}
	
	public void deleteMember(Member memDto) {
		try {
			String sql = "DELETE FROM member WHERE mem_no = ?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memDto.getMem_no());
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("DELETE 하다 프로세스 Exception 발생" + err);
			err.printStackTrace();
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
	}
	
	public void updateMember(Member memDto) {
		int mem_no = memDto.getMem_no();
		String id = memDto.getId();
		String pw = memDto.getPw();
		String birth = memDto.getBirth();
		String gender = memDto.getGender();
		String nick = memDto.getNick();
		String pic_url = memDto.getPic_url();
		
		try {
			String sql = "UPDATE member SET id = ?, pw = ?, birth = ?, gender = ?, nick = ?,"
					+ "pic_url = ? WHERE mem_no = ?";
			
			con = pool.getConnection();
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
			err.printStackTrace();
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
	}
	/* 중복된 아이디(이메일)가 있는지 확인하는 메소드 */
	public boolean isUniqueEmail(String email) {
		boolean isUnique = true;
		try {
			String sql = "SELECT * FROM member WHERE id = ?";
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			int count = 0;
			/* 만약 하나라도 SELECT된다면 중복이 있는것이므로 false를 리턴 */
			while(rs.next()) {
				count++;
				break;
			}
			
			if(count != 0) {
				isUnique = false;
			}
		} catch (SQLException err) {
			System.out.println("isDuplicatedEmail 하다 프로세스 Exception 발생" + err);
			err.printStackTrace();
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return isUnique;
	}
	
	private void closeConnection() {
		try {
			if(con != null)	con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException err) {
			System.out.println("Connection Close Error" + err);
			err.printStackTrace();
		}
	}
}

package repository;

import java.sql.*;
import java.util.ArrayList;

import dbcp.DBConnectionMgr;
import model.ShowOffBoard;

public class ShowOffBoardDao {
	private DBConnectionMgr pool;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ShowOffBoardDao() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception err) {
			System.out.println("DBConnnectionMgr.getInstance() fail : " + err);
		}
	}
	
	// showoff_main.jsp
	public ArrayList<ShowOffBoard> getShowOffList(){
		ArrayList<ShowOffBoard> showoffList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM showoff order by showoff_no desc";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShowOffBoard showoff = new ShowOffBoard();
				showoff.setShowoff_no(rs.getInt("showoff_no"));
				showoff.setMem_no(rs.getInt("mem_no"));
				showoff.setTitle(rs.getString("title"));
				showoff.setContent(rs.getString("content"));
				showoff.setDate(rs.getString("date"));
				showoff.setCnt(rs.getInt("cnt"));
				showoff.setLikes(rs.getInt("likes"));
				showoff.setPic_url(rs.getString("pic_url"));
				showoff.setEditor(rs.getString("editor"));
				showoffList.add(showoff);
			}
		} catch (SQLException err) {
			System.out.println("getShowOffList() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail : " + err);
			err.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return showoffList;
	}// end getShowOffList()
	
	// showoff_view.jsp
	public ShowOffBoard getShowOff(int showoff_no){
		ShowOffBoard showoff = new ShowOffBoard();
		try {
			String sql = "SELECT * FROM showoff WHERE showoff_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, showoff_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				showoff.setShowoff_no(rs.getInt("showoff_no"));
				showoff.setMem_no(rs.getInt("mem_no"));
				showoff.setTitle(rs.getString("title"));
				showoff.setContent(rs.getString("content"));
				showoff.setDate(rs.getString("date"));
				showoff.setCnt(rs.getInt("cnt"));
				showoff.setLikes(rs.getInt("likes"));
				showoff.setPic_url(rs.getString("pic_url"));
				showoff.setEditor(rs.getString("editor"));
			}
		} catch (SQLException err) {
			System.out.println("getShowOff() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return showoff;
	}// end getShowOff()
	
	// BoardPostController.java
	public void setShowOff(ShowOffBoard showoff) {
		try {
			String sql = "INSERT INTO showoff(mem_no, title, content, date, cnt, likes, pic_url, editor)"
					+ " values (?, ?, ?, now(), 0, 0, ?, ?)";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, showoff.getMem_no());
			pstmt.setString(2, showoff.getTitle());
			pstmt.setString(3, showoff.getContent());
			pstmt.setString(4, showoff.getPic_url());
			pstmt.setString(5, showoff.getEditor());
			
			pstmt.executeUpdate();
			
		} catch (SQLException err) {
			System.out.println("Insert 하다 프로세스 Exception 발생" + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			pool.freeConnection(con, pstmt, rs);
		}
	}
	
	public void setUpdateShowOff(ShowOffBoard showoff) {
		try {
			String sql = "UPDATE showoff SET pic_url=?, title=?, content=?, editor=? WHERE showoff_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, showoff.getPic_url());
			pstmt.setString(2, showoff.getTitle());
			pstmt.setString(3, showoff.getContent());
			pstmt.setString(4, showoff.getEditor());
			pstmt.setInt(5, showoff.getShowoff_no());
			pstmt.executeUpdate();
					
		}catch (SQLException e) {
			System.out.println("update 하다 프로세스 익셉션 발생 : " + e);
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("setUpdateShowOff() 에러 : " + e);
			e.printStackTrace();
		}finally {
			/* 접속 종료 */
			pool.freeConnection(con, pstmt, rs);
		}
	}
	
}// end ShowOffBoardDao class

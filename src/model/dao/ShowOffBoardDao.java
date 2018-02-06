package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.DBConnectionMgr;
import model.dto.ShowOffBoard;

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
				ShowOffBoard showoffDto = new ShowOffBoard();
				showoffDto.setShowoff_no(rs.getInt("showoff_no"));
				showoffDto.setMem_no(rs.getInt("mem_no"));
				showoffDto.setTitle(rs.getString("title"));
				showoffDto.setContent(rs.getString("content"));
				showoffDto.setDate(rs.getString("date"));
				showoffDto.setCnt(rs.getInt("cnt"));
				showoffDto.setLikes(rs.getInt("likes"));
				showoffDto.setIntro(rs.getString("intro"));
				showoffDto.setPic_url(rs.getString("pic_url"));
				showoffList.add(showoffDto);
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
				showoff.setIntro(rs.getString("intro"));
				showoff.setDate(rs.getString("date"));
				showoff.setCnt(rs.getInt("cnt"));
				showoff.setLikes(rs.getInt("likes"));
				showoff.setContent(rs.getString("content"));
				showoff.setPic_url(rs.getString("pic_url"));
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
	
}// end ShowOffBoardDao class

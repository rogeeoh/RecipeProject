package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.DBConnectionMgr;
import model.Ingre;
import model.Member;
import model.RecipeBoard;

public class IngreDao {
	private DBConnectionMgr pool;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public IngreDao() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception err) {
			System.out.println("DBConnnectionMgr.getInstance() fail" + err);
		}
	}
	
	public ArrayList<Ingre> getIngreList(int recpNo){
		/* DBConnection을 가져오기 종료 */
		ArrayList<Ingre> ingreList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM ingre WHERE recp_no = ?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recpNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Ingre newDto = new Ingre();
				
				int recp_no = rs.getInt("recp_no");
				String ingre = rs.getString("ingre");
				String amount = rs.getString("amount");
				
				newDto.setRecp_no(recp_no);
				newDto.setIngre(ingre);
				newDto.setAmount(amount);
				
				ingreList.add(newDto);
			}
		} catch (SQLException err) {
			System.out.println("getIngreList() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return ingreList;
	}
	
	
	public void deleteIngre(int recpNo){
		try {
			String sql = "DELETE FROM ingre WHERE recp_no = ?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recpNo);
			pstmt.executeUpdate();
			
		} catch (SQLException err) {
			System.out.println("deleteIngre() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
	}
	
	
	private void closeConnection() {
		try {
			if(con != null)	con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException err) {
			System.out.println("Connection Close Error" + err);
		}
	}
}

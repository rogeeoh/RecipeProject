package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.DBConnectionMgr;
import model.dto.Member;
import model.dto.RecipeBoard;

public class RecipeBoardDao {
	private DBConnectionMgr pool;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public RecipeBoardDao() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception err) {
			System.out.println("DBConnnectionMgr.getInstance() fail" + err);
		}
	}
	
	public ArrayList<RecipeBoard> getBoardList(){
		/* DBConnection을 가져오기 종료 */
		ArrayList<RecipeBoard> boardList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM recipe";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeBoard newDto = new RecipeBoard();
				
				int recp_no = rs.getInt("recp_no");
				String recp_name = rs.getString("recp_name");
				String nick = rs.getString("nick");
				String date = rs.getString("date");
				int cnt = rs.getInt("cnt");
				int likes = rs.getInt("likes");
				String recp_intro = rs.getString("recp_intro");
				String url = rs.getString("url");
				String ingre = rs.getString("ingre");
				String editor = rs.getString("editor");
				
				newDto.setRecp_no(recp_no);
				newDto.setRecp_name(recp_name);
				newDto.setNick(nick);
				newDto.setDate(date);
				newDto.setCnt(cnt);
				newDto.setLikes(likes);
				newDto.setRecp_intro(recp_intro);
				newDto.setUrl(url);
				newDto.setIngre(ingre);
				newDto.setEditor(editor);
				
				boardList.add(newDto);
			}
		} catch (SQLException err) {
			System.out.println("getBoardList() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return boardList;
	}
	
	public void insertBoard(RecipeBoard recipeDto) {
		// int recp_no = recipeDto.getRecp_no();
		String recp_name = recipeDto.getRecp_name(); 
		String nick = recipeDto.getNick();
		String date = recipeDto.getDate();
		int cnt = recipeDto.getCnt();
		int likes = recipeDto.getLikes();
		String recp_intro = recipeDto.getRecp_intro();
		String url = recipeDto.getUrl();
		String ingre = recipeDto.getIngre();
		String editor = recipeDto.getEditor();
		
		try {
			/* 수정 필요 */
			/* 수정 필요 */
			/* 수정 필요 */
			String sql = "INSERT INTO recipe(recp_name, nick, date, cnt, likes, recp_intro, url, ingre, editor)"
				+ " values (?, ?, now(), 0, 0, ?, ?, ?, ?)";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
		
			/* 수정 필요 */
			pstmt.setString(1, recp_name);
			pstmt.setString(2, nick);
			pstmt.setString(3, recp_intro);
			pstmt.setString(4, url);
			pstmt.setString(5, ingre);
			pstmt.setString(6, editor);
		
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("Insert 하다 프로세스 Exception 발생" + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
	}
	
	public void deleteBoard(RecipeBoard recipeDto) {
		try {
			String sql = "DELETE FROM recipe WHERE recp_no = ?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			int recp_no = recipeDto.getRecp_no();
			pstmt.setInt(1, recp_no);
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("DELETE 하다 프로세스 Exception 발생" + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
	}
	
	public void updateBoard(RecipeBoard recipeDto) {
		/* 이중 필요한 속성만 골라서 sql에 넣어야 함 */
		int recp_no = recipeDto.getRecp_no();
		String recp_name = recipeDto.getRecp_name(); 
		String nick = recipeDto.getNick();
		String date = recipeDto.getDate();
		int cnt = recipeDto.getCnt();
		int likes = recipeDto.getLikes();
		String recp_intro = recipeDto.getRecp_intro();
		String url = recipeDto.getUrl();
		String ingre = recipeDto.getIngre();
		String editor = recipeDto.getEditor();
		
		try {
			/*수정 필요!!!*/
			String sql = "UPDATE recipe SET id = ?, pw = ?, birth = ?, gender = ?, nick = ?,"
					+ "pic_url = ? WHERE mem_no = ?";
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			/*수정 필요!!!*/
//			pstmt.setString(1, );
//			pstmt.setString(2, );
//			pstmt.setString(3, );
//			pstmt.setString(4, );
//			pstmt.setString(5, );
//			pstmt.setString(6, );
//			pstmt.setString(7, );
//			pstmt.setString(8, );
//			pstmt.setString(9, );
//			pstmt.setString(10, );
			
			pstmt.executeUpdate();
		} catch (SQLException err) {
			System.out.println("update 하다 프로세스 Exception 발생" + err);
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

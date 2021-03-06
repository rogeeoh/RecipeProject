package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbcp.DBConnectionMgr;
import model.RecipeBoard;

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
	
	private ArrayList<RecipeBoard> resultSetToList(ResultSet rs) throws SQLException {
		ArrayList<RecipeBoard> boardList = new ArrayList<RecipeBoard>();
		
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
			int mem_no = rs.getInt("mem_no");
			
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
			newDto.setMem_no(mem_no);
			
			boardList.add(newDto);
		}
		
		return boardList;
	}
	
	public ArrayList<RecipeBoard> getBoardList(){
		/* DBConnection을 가져오기 종료 */
		ArrayList<RecipeBoard> boardList = null;
		try {
			String sql = "SELECT * FROM recipe ORDER BY recp_no desc";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			boardList = resultSetToList(rs);
		} catch (SQLException err) {
			System.out.println("getBoardList() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return boardList;
	}
	
	public ArrayList<RecipeBoard> getBoardList(String query){
		/* DBConnection을 가져오기 종료 */
		ArrayList<RecipeBoard> boardList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM recipe WHERE recp_name LIKE ? ORDER BY recp_no";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			rs = pstmt.executeQuery();
			
			boardList = resultSetToList(rs);
		} catch (SQLException err) {
			System.out.println("getBoardList() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return boardList;
	}
	
	public RecipeBoard getBoard(int recp_no){
		/* DBConnection을 가져오기 종료 */
		RecipeBoard recpBoard = new RecipeBoard();
		try {
			String sql = "SELECT * FROM recipe WHERE recp_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recp_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				recpBoard.setRecp_no(rs.getInt("recp_no"));
				recpBoard.setRecp_name(rs.getString("recp_name"));
				recpBoard.setNick(rs.getString("nick"));
				recpBoard.setDate(rs.getString("date"));
				recpBoard.setCnt(rs.getInt("cnt"));
				recpBoard.setLikes(rs.getInt("likes"));
				recpBoard.setRecp_intro(rs.getString("recp_intro"));
				recpBoard.setUrl(rs.getString("url"));
				recpBoard.setIngre(rs.getString("ingre"));
				recpBoard.setEditor(rs.getString("editor"));
				recpBoard.setMem_no(rs.getInt("mem_no"));
			}
		} catch (SQLException err) {
			System.out.println("getBoardList() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return recpBoard;
	}
	
	public void insertBoard(RecipeBoard recipeDto) {
		String recp_name = recipeDto.getRecp_name(); 
		String nick = recipeDto.getNick();
		String date = recipeDto.getDate();
		int cnt = recipeDto.getCnt();
		int likes = recipeDto.getLikes();
		String recp_intro = recipeDto.getRecp_intro();
		String url = recipeDto.getUrl();
		String ingre = recipeDto.getIngre();
		String editor = recipeDto.getEditor();
		int mem_no = recipeDto.getMem_no();
		
		try {
			String sql = "INSERT INTO recipe(recp_name, nick, date, cnt, likes, recp_intro, url, ingre, editor, mem_no)"
				+ " VALUES (?, ?, now(), 0, 0, ?, ?, ?, ?, ?)";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
		
			/* 수정 필요 */
			pstmt.setString(1, recp_name);
			pstmt.setString(2, nick);
			pstmt.setString(3, recp_intro);
			pstmt.setString(4, url);
			pstmt.setString(5, ingre);
			pstmt.setString(6, editor);
			pstmt.setInt(7, mem_no);
		
			pstmt.executeUpdate();
			
			
			sql = "SELECT recp_no FROM recipe WHERE recp_name = ? AND recp_intro = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, recp_name);
			pstmt.setString(2, recp_intro);
			
			rs = pstmt.executeQuery();
			rs.next();
			int recp_no = rs.getInt("recp_no");
			
			/* ingre update 처리 */
			String[] ingres = ingre.split(",");
			sql = "INSERT INTO ingre VALUE(?,?,?)";
			for(int i = 0; i < ingres.length; ++i) {
				pstmt = con.prepareStatement(sql);
				String[] ingreParse = ingres[i].split(":");
				pstmt.setInt(1, recp_no);
				pstmt.setString(2, ingreParse[0]);
				pstmt.setString(3, ingreParse[1]);
				pstmt.executeUpdate();
			}
			
		} catch (SQLException err) {
			System.out.println("Insert 하다 프로세스 Exception 발생" + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
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
	
	public void deleteBoard(int recpNo) {
		try {
			String sql = "DELETE FROM recipe WHERE recp_no = ?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, recpNo);
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
			
			String sql="UPDATE recipe SET recp_name=?, recp_intro=?, url=?, ingre=?, editor=? where recp_no =?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, recp_name);
			pstmt.setString(2, recp_intro);
			pstmt.setString(3, url);
			pstmt.setString(4, ingre);
			pstmt.setString(5, editor);
			pstmt.setInt(6, recp_no);
			pstmt.executeUpdate();
			
			sql = "DELETE FROM ingre WHERE recp_no = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, recp_no);
			pstmt.executeUpdate();
			/* ingre update 처리 */
			String[] ingres = ingre.split(",");
			
			sql = "INSERT INTO ingre VALUE(?,?,?)";
			for(int i = 0; i < ingres.length; ++i) {
				pstmt = con.prepareStatement(sql);
				String[] ingreParse = ingres[i].split(":");
				pstmt.setInt(1, recp_no);
				pstmt.setString(2, ingreParse[0]);
				pstmt.setString(3, ingreParse[1]);
				pstmt.executeUpdate();
			}
			
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
	
	private void closeConnection() {
		try {
			if(con != null)	con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException err) {
			System.out.println("Connection Close Error" + err);
		}
	}

	public int getTotalLength() {
		int totalCount = 0;
		try {
			String sql = "SELECT count(*) count FROM recipe;";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			totalCount = rs.getInt("count");
		} catch (SQLException err) {
			System.out.println("getTotalLength() 하다 프로세스 Exception 발생" + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		return totalCount;
	}

	public List<RecipeBoard> getBoardListByLimit(int start, int limit) {
		ArrayList<RecipeBoard> boardList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM recipe ORDER BY recp_no LIMIT ?, ?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			
			boardList = resultSetToList(rs);
		} catch (SQLException err) {
			System.out.println("getBoardListByLimit() error : " + err);
		} catch (Exception err) {
			System.out.println("pool.getConnection() fail" + err);
			err.printStackTrace();
		} finally {
			/* 접속 종료 */
			closeConnection();	
		}
		
		return boardList;
	}
}

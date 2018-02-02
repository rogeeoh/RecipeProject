package model.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.gson.Gson;

import dbcp.DBConnectionMgr;

public class test {
	
	public static void main(String[] args) throws Exception{
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM member";
		pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		
		ArrayList<Member> arListMember = new ArrayList<Member>();
		
		while(rs.next()) {
			Member dto = new Member();
			dto.setMem_no(rs.getInt("mem_no"));
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setBirth(rs.getString("birth"));
			dto.setGender(rs.getString("gender"));
			dto.setNick(rs.getString("nick"));
			dto.setPic_url(rs.getString("pic_url"));
			arListMember.add(dto);
			cnt++;
		}
		
		for(Member m : arListMember) {
			System.out.println(m);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(arListMember);
		System.out.println("json : " + json);
		
		System.out.println("cnt : " + cnt);
	}
}

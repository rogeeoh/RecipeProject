package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RecipeModifyCommand implements Command{
	private Integer recpNo;
	
	public RecipeModifyCommand(Integer recpNo) {
		this.recpNo = recpNo;
	}
	
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// DAO로 해당 글 번호에 해당하는 DTO 가져와서 화면에 출력하기
		Object dto = null;
		req.setAttribute("dto", dto);
		System.out.println(recpNo + "번째 글을 수정합니다.");

		String url = "/WEB-INF/recipe/recipe_modify.jsp";
		return url;
	}
}

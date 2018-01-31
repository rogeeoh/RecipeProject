package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RecipeDeleteCommand implements Command{
	private Integer recpNo;
	
	public RecipeDeleteCommand(Integer recpNo) {
		this.recpNo = recpNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* recpNo번에 해당하는 글을 삭제하는 작업 진행 */
		
		System.out.println(recpNo + "번 글을 삭제하였습니다.");
		
		String url = "/WEB-INF/recipe/recipe_main.jsp";
		return url;
	}
}

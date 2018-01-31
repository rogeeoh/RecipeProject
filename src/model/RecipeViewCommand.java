package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RecipeViewCommand implements Command{

	private Integer recpNo;
	public RecipeViewCommand(Integer recpNo) {
		this.recpNo = recpNo;
	}
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* DB로부터 recpNo에 해당하는 DTO를 불러와서 */
		Object dto = null;
		/* Attribute에 추가하고 */
		req.setAttribute("dto", dto);
		/* 해당 URL로 이동 */
		String url = "/WEB-INF/recipe/recipe_view.jsp";
		
		return url;
	}
}

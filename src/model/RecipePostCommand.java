package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RecipePostCommand implements Command{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String dir = "/images/recipe/";
		String path = req.getServletContext().getRealPath(dir);
		// System.out.println("servletContextRealPath : " + path);
		
		int maxSize = 1024*1024*50;
		MultipartRequest multi = 
					new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		/* 받아온 데이터를 DB에 연결해서 저장해준다. */
		
		String title = multi.getParameter("title");
		String intro = multi.getParameter("intro");
		String[] ingre = multi.getParameterValues("ingre");
		String[] ingreAmount = multi.getParameterValues("ingre_amount");
		String editor = multi.getParameter("editor"); 
		
		Enumeration enumer = multi.getFileNames();
		while(enumer.hasMoreElements()){
			// 파일 이름을 하나씩 받아온다.
			String name = (String)enumer.nextElement();
			System.out.println("실제 파일명 : " + multi.getOriginalFileName(name));
			System.out.println("저장될 파일명 : " + multi.getFilesystemName(name));
			System.out.println("DB 저장경로 : " + dir + multi.getFilesystemName(name));
			// System.out.println("파일 타입: " + multi.getContentType(name));
			//File f = multi.getFile(name);
			//System.out.println("파일 크기 : " + f.length() + "byte");
			//System.out.println("파일 경로 : " + f.getPath());
		}
		
		System.out.println("title : " + title);
		System.out.println("intro : " + intro);
		for(int i = 0; i < ingre.length; ++i) {
			System.out.println("ingre " + i + " : " + ingre[i] + ", " + ingreAmount[i]);
		}
		System.out.println("editor : " + editor);
		
		
		// 수정 필요함; 내가 쓴 글로 이동하도록 경로를 잡아주어야 함
		String url = "/WEB-INF/recipe/recipe_main.jsp";
		
		return url;
	}
}

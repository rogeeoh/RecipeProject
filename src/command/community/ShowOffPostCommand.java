package command.community;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.Command;
import model.ShowOffBoard;
import repository.ShowOffBoardDao;

public class ShowOffPostCommand implements Command {
	private Integer showoffNo;
	
	public ShowOffPostCommand(Integer showoffNo) {
		this.showoffNo = showoffNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String prj = "/recipe_project";
		String dir = "/images/community/showoff/";
		String path = req.getServletContext().getRealPath(dir);
		//System.out.println("servletContextRealPath : " + path);
		
		int maxSize = 1024*1024*50;
		MultipartRequest multi = 
					new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Enumeration enumer = multi.getFileNames();
		String picture = multi.getFilesystemName((String)enumer.nextElement());
		String pic_url = prj + dir + picture;
		
		/* 받아온 데이터를 model에 세팅 */
		ShowOffBoard showoff = new ShowOffBoard();
		if(showoffNo != null) {
			showoff.setShowoff_no(showoffNo);
		}
		if(picture == null) {
			showoff.setPic_url(multi.getParameter("original_image"));
		}else {
			showoff.setPic_url(pic_url);
		}
		showoff.setTitle(multi.getParameter("title"));
		showoff.setContent(multi.getParameter("content"));
		showoff.setEditor(multi.getParameter("editor"));
		
		ShowOffBoardDao showoffDao = new ShowOffBoardDao();
		String url = null;		
		if(showoffNo == null) {
			showoffDao.setShowOff(showoff);
			url = "community_showoff";
		}
		else{
			showoffDao.setUpdateShowOff(showoff);
			url = "community_showoff?no="+showoffNo;
		}
		return url;
		
	}

}

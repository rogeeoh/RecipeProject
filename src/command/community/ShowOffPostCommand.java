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
	
	public ShowOffPostCommand(int showoffNo) {
		this.showoffNo = showoffNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String prj = "/recipe_project";
		String dir = "/images/showoff/";
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
		if(showoff != null) {
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
		
		String url = null;		
		if(showoffNo == null) {
			new ShowOffBoardDao().setShowOff(showoff);
			url = "community_showoff";
		}
		else{
			//showoffDao.setUpdate(showoff);
			/* 해당 글로 이동하는 url을 잡아줄것 */
			url = "community_showoff?no="+showoffNo;
		}
		
		// 수정 필요함; 내가 쓴 글로 이동하도록 경로를 잡아주어야 함
		return url;
		
	}

}

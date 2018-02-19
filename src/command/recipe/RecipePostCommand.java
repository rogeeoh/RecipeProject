package command.recipe;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.Command;
import model.RecipeBoard;
import repository.IngreDao;
import repository.RecipeBoardDao;

public class RecipePostCommand implements Command{
	private Integer recpNo;
	
	public RecipePostCommand(Integer recpNo) {
		this.recpNo = recpNo;
	}
	
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String prj = "/recipe_project";
		String dir = "/images/recipe/";
		String path = req.getServletContext().getRealPath(dir);
		//System.out.println("servletContextRealPath : " + path);
		
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
		String picture = multi.getFilesystemName((String)enumer.nextElement());
		String picUrl = prj + dir + picture;
		
		String ingres = "";
		for(int i = 0; i < ingre.length; ++i) {
//			System.out.println("ingre : " + ingre[i]);
//			System.out.println("ingreAmount : " + ingreAmount[i]);
			if(ingre[i].equals("") || ingreAmount[i].equals(""))
				continue;
			ingres += ingre[i] + ":" + ingreAmount[i] + ",";
		}

		ingres = ingres.substring(0, ingres.length() - 1);
//		System.out.println("recipepostcommand ingres : " + ingres);
		
		
		RecipeBoard recipeDto = new RecipeBoard();
		/* dto 만들어서 보내줌 */
		if(recpNo != null)
			recipeDto.setRecp_no(recpNo);
		System.out.println("picture : " + picture);
		if(picture == null) {
			System.out.println("multi.getParameter(\"original_image\") : " + multi.getParameter("original_image"));
			recipeDto.setUrl(multi.getParameter("original_image"));
		}
		else {
			System.out.println("picUrl : " + picUrl);
			recipeDto.setUrl(picUrl);
		}
		recipeDto.setRecp_name(title);
		recipeDto.setRecp_intro(intro);
		recipeDto.setIngre(ingres);
		recipeDto.setEditor(editor);
		System.out.println("editor: " + editor);
		
		RecipeBoardDao recpDao = new RecipeBoardDao();
		IngreDao ingreDao = new IngreDao();
		
		String url = null;
		if(recpNo == null) {
			recpDao.insertBoard(recipeDto);
			url = "recipe";
		}
		else{
			recpDao.updateBoard(recipeDto);
			/* 해당 글로 이동하는 url을 잡아줄것 */
			url = "recipe?no="+recpNo;
		}
		
		// 수정 필요함; 내가 쓴 글로 이동하도록 경로를 잡아주어야 함
		return url;
	}
}

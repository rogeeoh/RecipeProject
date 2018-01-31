package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUploadController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		System.out.println("UploadController Called");
		
		String cmd = req.getParameter("cmd");
		PrintWriter out = resp.getWriter();
//		
//		switch(cmd) {
//			case "img":
//				break;
//		}
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);  //multipart로 전송되었는가 체크
		if (isMultipart) {
			// 설정단계
			
	 		File temporaryDir = new File("c:\\tmp\\");  //업로드된 파일의 임시 저장 폴더
	 		String realDir = req.getServletContext().getRealPath(req.getParameter("realDir"));  //실제 저장될 파일경로
	 		String sFunc = req.getParameter("CKEditorFuncNum");
	 		String realUrl = req.getParameter("realUrl");

	 		// 디스크 기반의 파일 아이템 팩토리 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1 * 1024 * 1024);  //최대 메모리 크기
			factory.setRepository(temporaryDir);  // 임시저장폴더 연결

			// 구현단계
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(10 * 1024 * 1024);  //최대 업로드 크기
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} //이 부분에서 파일이 생성
			
			Iterator iter = items.iterator();
	 
			while (iter.hasNext()) {
				FileItem fileItem = (FileItem) iter.next();
				if (fileItem.isFormField()) {  // File 컴포넌트가 아닌 일반 컴포넌트일 경우
					out.println(fileItem.getFieldName() + "=" + fileItem.getString("euc-kr"));
				}else{
					if (fileItem.getSize() > 0) {  //파일이 업로드 되었나 안되었나 체크
						String fieldName = fileItem.getFieldName();
						String fileName = fileItem.getName();
						String contentType = fileItem.getContentType();
						boolean isInMemory = fileItem.isInMemory();
						long sizeInBytes = fileItem.getSize();
						
						 
				 		System.out.println("[realDir] : "+ realDir);
				 		System.out.println("[fieldName] : "+ fieldName);
				 		System.out.println("[fileName] : "+ fileName);
				 		System.out.println("[contentType] : "+ contentType);
				 		System.out.println("[isInMemory] : "+ isInMemory);
				 		System.out.println("[sizeInBytes] : "+ sizeInBytes);
				 		
				 		out.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(" + sFunc + ", '"+ realUrl + fileName + "', '완료');</script>");

				 		try {
				 			File uploadedFile = new File(realDir, fileName);
				 			fileItem.write(uploadedFile);  //실제 디렉토리에 카피
				 			fileItem.delete();   //temp폴더의 파일 제거
				 		} catch(Exception ex) {
				 			out.println("error : "+ ex +"<br/>");
				 		}
					}
				}
			}
		} else {
//	 		out.println("인코딩 타입이 multipart/form-data 가 아님.");
		}
		
		out.close();
	}
}

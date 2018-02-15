package command.manage;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.Command;

public class ManageMemberCommand implements Command{
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* manage_main은 member를 컨트롤 하는 jsp */
		String url = "/WEB-INF/manage/manage_main.jsp";
		return url;
	}
}

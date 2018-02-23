package factory;

import command.Command;
import command.manage.ajax.AjaxMemberCommand;
import service.CheckIdDuplicatedAjax;
import service.CheckIdMatchesAjax;

// Factory Pattern
public class AjaxFactory {
	private AjaxFactory() {}
	
	public static AjaxFactory instance = new AjaxFactory();
	
	public static AjaxFactory newInstance() {
		return instance;
	}
	
	/* 차후 관리자페이지 전용 ajax와 분리할 예정임*/
	public Command createInstance(String board, String command) {
		/* 만약 parameter가 null이면 기본 페이지로 이동하게 설정 */
		
		Command iCmd = null;
		if(command == null) command = "";
		switch(command) {
			case "chk_id":
				return new CheckIdDuplicatedAjax();
			case "chk_session":
				return new CheckIdMatchesAjax();
		}
	
		return iCmd;
	}
}

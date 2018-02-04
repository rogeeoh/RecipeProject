package model.ajax;

import model.Command;

// Factory Pattern
public class AjaxFactory {
	private AjaxFactory() {}
	
	public static AjaxFactory instance = new AjaxFactory();
	
	public static AjaxFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String board, String command) {
		/* 만약 parameter가 null이면 기본 페이지로 이동하게 설정 */
		
		Command iCmd = null;
		
		switch(command) {
		case "chk_id":
			iCmd = new AjaxCheckIdCommand();
			break;
		}
		
		if(iCmd != null)
			return iCmd;
		
		if(board == null) {
			board = "member";
		}
		
		switch(board) {
			/* 이하 케이스는 admin권한 체크 반드시 필요함.*/
			case "member":
				iCmd = new AjaxMemberCommand(command);
				break;
			case "board":
				iCmd = new AjaxBoardCommand(command);
				break;
			case "lecture":
				//iCmd = new AjaxLectureCommand(command);
				break;
		}
	
		return iCmd;
	}
}

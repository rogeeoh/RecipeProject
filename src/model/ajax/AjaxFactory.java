package model.ajax;

import model.Command;

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
				return new AjaxCheckIdCommand();
		}
		
		if(board == null) board = "member";
		
		switch(board) {
			/* 이하 케이스는 admin권한 체크 반드시 필요함.*/
			case "member":
				return new AjaxMemberCommand(command);
			case "board":
				return new AjaxBoardCommand(command);
			case "lecture":
				//iCmd = new AjaxLectureCommand(command);
				break;
		}
	
		return iCmd;
	}
}

package model.ajax;

import model.Command;

// Factory Pattern
public class AjaxFactory {
	private AjaxFactory() {}
	
	public static AjaxFactory instance = new AjaxFactory();
	
	public static AjaxFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String command) {
		/* 만약 parameter가 null이면 기본 페이지로 이동하게 설정 */
		if(command == null) {
			return new AjaxMemberCommand();
		}
		
		Command iCmd = null;
		switch(command) {
			case "member":
				// 글 쓰기
				iCmd = new AjaxMemberCommand();
				break;
			case "board":
				// 글 수정
				//iCmd = new AjaxBoardCommand();
				break;
			case "lecture":
				// 글 삭제
				//iCmd = new AjaxLectureCommand();
				break;
		}
	
		return iCmd;
	}
}

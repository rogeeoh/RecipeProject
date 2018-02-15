package factory;

import command.Command;
import command.manage.ManageBoardCommand;
import command.manage.ManageLectureCommand;
import command.manage.ManageMemberCommand;

// Factory Pattern
public class ManageFactory {
	private ManageFactory() {}
	
	public static ManageFactory instance = new ManageFactory();
	
	public static ManageFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String command) {
		/* 만약 parameter가 null이면 기본 페이지로 이동하게 설정 */
		if(command == null) {
			return new ManageMemberCommand();
		}
		
		Command iCmd = null;
		switch(command) {
			case "member":
				// 글 쓰기
				iCmd = new ManageMemberCommand();
				break;
			case "board":
				// 글 수정
				iCmd = new ManageBoardCommand();
				break;
			case "lecture":
				// 글 삭제
				iCmd = new ManageLectureCommand();
				break;
		}
	
		return iCmd;
	}
}

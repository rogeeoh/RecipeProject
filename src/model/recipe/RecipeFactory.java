package model.recipe;

import model.Command;
import model.login.LoginCommand;

// Factory Pattern
public class RecipeFactory {
	private RecipeFactory() {}
	
	public static RecipeFactory instance = new RecipeFactory();
	
	public static RecipeFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String command, Integer recpNo) {
		if(command == null) {
		// 만약 localhost:8080/recipe 경로로 접근한 것이라면 메인페이지로 이동한다
			if(recpNo == null) {
				// 메인으로 이동하는 command 생성
				return new RecipeMainCommand();
			}
			/* recipe?no=글번호 를 통해 글을 보고 싶은 거라면 */
			return new RecipeViewCommand(recpNo);
		}
		
		Command iCmd = null;
		
		switch(command) {
			case "write":
				// 글 쓰기
				iCmd = new RecipeWriteCommand();
				break;
			case "modify":
				// 글 수정
				iCmd = new RecipeModifyCommand(recpNo);
				break;
		}
	
		return iCmd;
	}
}

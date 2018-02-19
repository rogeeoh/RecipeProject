package factory;

import command.Command;
import command.community.ShowOffMainCommand;
import command.community.ShowOffViewCommand;
import command.community.ShowOffWriteCommand;
import command.recipe.RecipeModifyCommand;
import command.recipe.RecipeWriteCommand;

public class ShowOffFactory {
	private ShowOffFactory() {}
	
	public static ShowOffFactory instance = new ShowOffFactory();
	
	public static ShowOffFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String cmd, Integer showoffNo) {
		if(cmd == null) {
			if(showoffNo == null) {
				return new ShowOffMainCommand();
			}
			return new ShowOffViewCommand(showoffNo);
		}
		
		Command iCmd = null;
		
		switch(cmd) {
			case "write":
				// 글 쓰기
				iCmd = new ShowOffWriteCommand();
				break;
			case "modify":
				// 글 수정
				// iCmd = new ShowOffModifyCommand(showoffNo);
				break;
		}
	
		return iCmd;
	}
}

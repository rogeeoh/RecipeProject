package factory;

import command.Command;
import command.recipe.RecipeDeleteCommand;
import command.recipe.RecipePostCommand;

// Factory Pattern
public class FactoryDeleteBoard {
	private FactoryDeleteBoard() {}
	public static FactoryDeleteBoard instance = new FactoryDeleteBoard();
	
	public static FactoryDeleteBoard newInstance() {
		return instance;
	}
	
	public Command createInstance(String command, String no) {
		Command iCmd = null;
		
		switch(command) {
			/* 레시피 게시판에 업로드 하는 경우 */
			case "recipe":
				iCmd = new RecipeDeleteCommand(Integer.parseInt(no));
				break;
			case "free":
				//iCmd = new ConfirmCommand();
				break;
		}
		
		return iCmd;
	}
}

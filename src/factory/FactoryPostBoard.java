package factory;

import command.Command;
import command.community.ShowOffPostCommand;
import command.recipe.RecipePostCommand;

// Factory Pattern
public class FactoryPostBoard {
	private FactoryPostBoard() {}
	public static FactoryPostBoard instance = new FactoryPostBoard();
	
	public static FactoryPostBoard newInstance() {
		return instance;
	}
	
	public Command createInstance(String command, Integer boardNo) {
		Command iCmd = null;
		
		switch(command) {
			/* 레시피 게시판에 업로드 하는 경우 */
			case "recipe":
				iCmd = new RecipePostCommand(boardNo);
				break;
			
			/* 뽐내기 게시판에 업로드 */
			case "showoff":
				iCmd = new ShowOffPostCommand(boardNo);
				break;
				
			case "free":
				//iCmd = new ConfirmCommand();
				break;
		}
		
		return iCmd;
	}
}

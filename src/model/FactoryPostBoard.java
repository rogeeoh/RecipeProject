package model;

import model.recipe.RecipePostCommand;

// Factory Pattern
public class FactoryPostBoard {
	private FactoryPostBoard() {}
	public static FactoryPostBoard instance = new FactoryPostBoard();
	
	public static FactoryPostBoard newInstance() {
		return instance;
	}
	
	public Command createInstance(String command) {
		Command iCmd = null;
		
		switch(command) {
			/* 레시피 게시판에 업로드 하는 경우 */
			case "recipe":
				iCmd = new RecipePostCommand();
				break;
			case "free":
				//iCmd = new ConfirmCommand();
				break;
		}
		
		return iCmd;
	}
}

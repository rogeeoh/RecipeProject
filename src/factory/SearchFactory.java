package factory;

import command.Command;
import command.recipe.RecipeMainCommand;
import command.recipe.RecipeModifyCommand;
import command.recipe.RecipeViewCommand;
import command.recipe.RecipeWriteCommand;
import command.search.SearchCommand;
import command.user.LoginCommand;

// Factory Pattern
public class SearchFactory {
	private SearchFactory() {}
	
	public static SearchFactory instance = new SearchFactory();
	
	public static SearchFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String board, String query) {
		Command iCmd = null;
	
		iCmd = new SearchCommand(query);
		
		return iCmd;
	}
}

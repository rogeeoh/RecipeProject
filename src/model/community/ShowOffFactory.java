package model.community;

import model.Command;

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
			return new ShowOffMainCommand();
		}
		return new ShowOffMainCommand();
	}
}

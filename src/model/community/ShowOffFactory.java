package model.community;

import model.Command;

public class ShowOffFactory {
	private ShowOffFactory() {}
	
	public static ShowOffFactory instance = new ShowOffFactory();
	
	public static ShowOffFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String cmd, Integer postNo) {
		if(cmd == null) {
			if(postNo == null) {
				return new ShowOffMainCommand();
			}
			return null;
		}
		return null;
	}
}

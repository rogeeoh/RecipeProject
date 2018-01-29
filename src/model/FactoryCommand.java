package model;

// Factory Pattern
public class FactoryCommand {
	private FactoryCommand() {}
	
	public static FactoryCommand instance = new FactoryCommand();
	
	public static FactoryCommand newInstance() {
		return instance;
	}
	
	public Command createInstance(String command) {
		Command iCmd = null;
		
		switch(command) {
			case "REGISTER":
				//iCmd = new RegisterCommand();
				break;
			case "CONFIRM":
				//iCmd = new ConfirmCommand();
				break;
			case "COMPLETE":
				//iCmd = new CompleteCommand();
				break;
			case "MAIN":
				//iCmd = new MainCommand();
				break;
		}
		
		return iCmd;
	}
}

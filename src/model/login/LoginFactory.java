package model.login;

import model.Command;

// Factory Pattern
public class LoginFactory {
	private LoginFactory() {}
	
	public static LoginFactory instance = new LoginFactory();
	
	public static LoginFactory newInstance() {
		return instance;
	}
	
	public Command createInstance(String command) {
		Command iCmd = null;
		
		switch(command) {
			case "login":
				// 로그인페이지로 이동
				iCmd = new LoginCommand();
				break;
			case "login_try":
				// 로그인 시도
				iCmd = new LoginTryCommand();
				break;
			case "logoff":
				// 로그오프
				iCmd = new LogoffCommand();
				break;
			case "find_id":
				iCmd = new FindIdCommand();
				break;
			case "find_id_page":
				iCmd = new FindIdPageCommand();
				break;
			case "create_account":
				iCmd = new CreateAccountCommand();
				break;
			case "create_account_page":
				iCmd = new CreateAccountPageCommand();
				break;
		}
	
		return iCmd;
	}
}

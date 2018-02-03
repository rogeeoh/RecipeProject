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
			case "login_page":
				// 로그인페이지로 이
				iCmd = new LoginPageCommand();
				break;
			case "login":
				// 로그인 시도
				iCmd = new LoginCommand();
				break;
			case "logoff":
				// 로그오프
				iCmd = new LogoffCommand();
				break;
		}
	
		return iCmd;
	}
}
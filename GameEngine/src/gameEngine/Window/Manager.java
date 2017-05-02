package gameEngine.Window;

import com.gmail.sitoa.TextLoadProgram.TextLoadClass;

public class Manager {
	private static Manager instance = new Manager();
	TextLoadClass TLC;
	
	Manager(){
		TLC = new TextLoadClass();
	}
	
	
	public TextLoadClass getTLC(){
		return TLC;
	}
	
	
	public static Manager getInstance(){
		return instance;
	}

}

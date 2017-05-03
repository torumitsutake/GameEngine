package gameEngine.Window.SavingSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveDate implements Serializable {
	public String ReachingPoint = "1-1";
	public String LastTimePoint = "1-1";
	//saveID管理
	ArrayList<String> saveIDs = new ArrayList<String>();
	HashMap<String,String> savestrings  = new HashMap<String,String>();
	

	
	
	public boolean addpoint(String value){
		String key = "";
		

		savestrings.put(key, value);

		return true;
	}







}

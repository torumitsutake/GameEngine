package gameEngine.Window.SavingSystem;

public class Save {
	String endpoint = "";
	String samunepath = "";
	int SaveID = 0;
	public Save(int id){
		SaveID = id;
	}

	public void setPoint(int f,int i){
		endpoint = f+""+i;
	}
	public void setPath(String path){
	samunepath = path;
	}



	public String getEndpoint(){
		return endpoint;
	}

	public String getSamunePath(){
		return samunepath;
	}







}

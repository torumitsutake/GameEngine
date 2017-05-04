package gameEngine.Window.SavingSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveFileManager {
	private static SaveFileManager SFM = new SaveFileManager();
	public SaveDate SD;

	SaveFileManager(){
		load();
	}

	public SaveDate getSaveDate(){
		if(SD == null){reCreateSaveFile();}
		return SD;
	}

	public boolean load(){
		try {
		    FileInputStream fis = new FileInputStream("Save.dat");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    SD = (SaveDate) ois.readObject();
		    ois.close();
		} catch (Exception e) {


			return false;
		}

		return true;
	}

	public boolean save(){
		if(SD == null){
			reCreateSaveFile();
		}
		try{
			FileOutputStream fou = new FileOutputStream("Save.dat",true);
			ObjectOutputStream oos = new ObjectOutputStream(fou);
			oos.writeObject(SD);
			oos.close();


		}catch (Exception e){
			return false;

			}



		return true;
	}


	public static SaveFileManager getInstance(){
	return SFM;
	}


	private boolean reCreateSaveFile(){
		SaveDate sade = new SaveDate();
		SD = sade;
		save();


		return true;
	}





}

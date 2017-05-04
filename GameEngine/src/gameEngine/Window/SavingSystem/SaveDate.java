package gameEngine.Window.SavingSystem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.gmail.sitoa.TextLoadProgram.FileLoadManager;

import gameEngine.Window.Manager;
import gameEngine.Window.Panel.StoryPanel;
//セーブデータをまとめて、保存する
public class SaveDate implements Serializable {
	public String ReachingPoint = "1-1";
	public String LastTimePoint = "1-1";
	//saveID管理
	HashMap<Integer,Save> savedates = new HashMap<Integer,Save>();

	public String getRP(){
		return ReachingPoint;
	}
	public String getLP(){
		return LastTimePoint;
	}

	public void refleshRP(String n){
		ReachingPoint = n;
	}

	public void refleshLP(String  n){
		LastTimePoint = n;

	}

	public boolean Savenow(int saveid){
		int file = FileLoadManager.getInstance().getNowfileindex();
		int line = Manager.getInstance().getTLC().getNowindex();
		StoryPanel SP = StoryPanel.getInstance();
		BufferedImage image = SP.getCapture();
		Save save = new Save(saveid);
		save.setPoint(file, line);
		save.setPath( "savedat/"+saveid+"-sam.jpeg");


        try {
			ImageIO.write( image, "jpeg", new File( "savedat/"+saveid+"-sam.jpeg" ) );
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
			return false;
		}
        return true;


	}









}

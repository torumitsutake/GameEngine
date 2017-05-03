package gameEngine.Window.Listener;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import com.gmail.sitoa.TextLoadProgram.CommandmatchClass;
import com.gmail.sitoa.TextLoadProgram.TextLoadClass;

import gameEngine.Window.Manager;
import gameEngine.Window.Font.FontMaker;
import gameEngine.Window.Frame.SizeManager;
import gameEngine.Window.Panel.PictureBuilder;
import gameEngine.Window.Panel.StoryPanel;
import gameEngine.Window.Panel.TextShowClass;

public class PanelClickListener implements MouseListener {
	public static boolean TSCopen = false;
	String txt ="";
	@Override
	public void mouseClicked(MouseEvent e) {
		gotonexttext();

	}

	public void gotonexttext(){



		StoryPanel SP =StoryPanel.getInstance();
		if(TSCopen==false){


		TextLoadClass TLC =Manager.getInstance().getTLC();

		txt = TLC.next();
		while(!(txt.matches(".*:.*"))){txt = TLC.next();}


		CommandmatchClass CMC = new CommandmatchClass(txt);
		String cmd = CMC.getCmd();
		//コマンドによる特定処理
		if(cmd.equalsIgnoreCase("BGP")){
			SP.getBGP().setIcon(PictureBuilder.resizeIcon(new ImageIcon(CMC.getOption()), SizeManager.getGlobalWidth(), SizeManager.getGlobalHeight()));
			SP.revalidate();
			gotonexttext();
			return;
		}
		if(cmd.equalsIgnoreCase("Font")){
			try {
				Font exFont = FontMaker.makeFont(new URL("file:resource/ipaexg.ttf"),Float.parseFloat(CMC.getOption()));
				SP.getTextArea().setFont(exFont);
			} catch (MalformedURLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gotonexttext();
			return;


		}





		//以下コマンド以外の処理
		if(!(cmd.equalsIgnoreCase("SE")||(cmd.equalsIgnoreCase("BGM"))||
				(cmd.equalsIgnoreCase("CV"))||(cmd.equalsIgnoreCase("BGMPAUSE"))||
				(cmd.equalsIgnoreCase("BGMRE"))||(cmd.equalsIgnoreCase("BGMSTOP"))||
				(cmd.equalsIgnoreCase("Font"))||(cmd.equalsIgnoreCase("SELECT"))
				||(cmd.equalsIgnoreCase("BGMFade")))){
			TextShowClass TSC = TextShowClass.getInstance();
			SP.getTextArea().setText("");
			TSC.setText(CMC.getOption());
			TSCopen = true;
			System.out.println(CMC.getOption());
			TSC.start();
			SP.getNameLabel().setText(cmd);
			SP.revalidate();
		}else{
			gotonexttext();
		}
		}else{
			TSCopen = false;
			System.out.println("PCL46");
			CommandmatchClass CMC = new CommandmatchClass(txt);
			String cmd = CMC.getCmd();
			if(!(cmd.equalsIgnoreCase("SE")||(cmd.equalsIgnoreCase("BGM"))||
					(cmd.equalsIgnoreCase("CV"))||(cmd.equalsIgnoreCase("BGMPAUSE"))||
					(cmd.equalsIgnoreCase("BGMRE"))||(cmd.equalsIgnoreCase("BGMSTOP"))||
					(cmd.equalsIgnoreCase("Font"))||(cmd.equalsIgnoreCase("SELECT"))
					||(cmd.equalsIgnoreCase("BGMFade")))){
				TextShowClass TSC = TextShowClass.getInstance();
				TSC.shutdown();
				SP.getTextArea().setText("");
				SP.getTextArea().setText(CMC.getOption());
				SP.getNameLabel().setText(cmd);
				SP.revalidate();
			}else{
				gotonexttext();
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}

package gameEngine.Window.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.gmail.sitoa.TextLoadProgram.CommandmatchClass;
import com.gmail.sitoa.TextLoadProgram.TextLoadClass;

import gameEngine.Window.Manager;
import gameEngine.Window.Panel.StoryPanel;

public class PanelClickListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		TextLoadClass TLC =Manager.getInstance().getTLC();
		String txt = TLC.next();
		while(!(txt.matches(".*:.*"))){txt = TLC.next();}


		CommandmatchClass CMC = new CommandmatchClass(txt);
		StoryPanel SP =StoryPanel.getInstance();
		String cmd = CMC.getCmd();
		if(!(cmd.equalsIgnoreCase("SE")||(cmd.equalsIgnoreCase("BGM"))||(cmd.equalsIgnoreCase("CV")))){
			SP.getTextArea().setText(CMC.getOption());
			SP.getNameLabel().setText(cmd);
			SP.revalidate();
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

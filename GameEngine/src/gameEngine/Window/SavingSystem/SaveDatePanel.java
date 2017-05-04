package gameEngine.Window.SavingSystem;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//セーブデータ一つ一つのコマみたいなの

public class SaveDatePanel extends JPanel {
	
	boolean savefile = false;
	int saveID = 0;
	ImageIcon samune = new ImageIcon();
	Save saved = new Save(saveID);

	public SaveDatePanel(Save s) {
		saved = s;

	}

}

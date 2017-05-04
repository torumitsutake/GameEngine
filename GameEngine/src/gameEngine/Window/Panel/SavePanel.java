package gameEngine.Window.Panel;

import javax.swing.JPanel;

import gameEngine.Window.Frame.SizeManager;

public class SavePanel extends JPanel {
	int WIDTH = SizeManager.getGlobalWidth();
	int HEIGHT = SizeManager.getGlobalHeight();
	/**
	 * Create the panel.
	 * セーブ画面
	 */
	public SavePanel() {

		setSize(WIDTH,HEIGHT);




	}

}

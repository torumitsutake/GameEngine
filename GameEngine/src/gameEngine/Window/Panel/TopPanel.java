package gameEngine.Window.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gameEngine.Window.Frame.MainFrame;
import gameEngine.Window.Frame.SizeManager;

public class TopPanel extends JPanel {
	int WIDTH = SizeManager.getGlobalWidth();
	int HEIGHT = SizeManager.getGlobalHeight();

	/**
	 * Create the panel.
	 */
	public TopPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);

		JButton Start = new JButton("Start");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().changePanel(1);

			}
		});
		Start.setBounds(924, 95, 234, 40);
		add(Start);

		JButton Load = new JButton("Load");
		Load.setBounds(925, 156, 234, 40);
		add(Load);

		JLabel BGP = new JLabel("");
		BGP.setBounds(0, 5, 1280, 720);
		BGP.setHorizontalAlignment(SwingConstants.CENTER);

		BGP.setIcon(PictureBuilder.resizeIcon(new ImageIcon("resource/BGP/testpic.jpg"), WIDTH, HEIGHT));
		add(BGP);

	}
}

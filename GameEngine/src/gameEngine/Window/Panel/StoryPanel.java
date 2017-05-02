package gameEngine.Window.Panel;

import java.awt.Font;
import java.awt.Insets;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.gmail.sitoa.TextLoadProgram.TextLoadClass;

import gameEngine.Window.Manager;
import gameEngine.Window.Font.FontMaker;
import gameEngine.Window.Frame.SizeManager;
import gameEngine.Window.Listener.PanelClickListener;

public class StoryPanel extends JPanel {
	private static  StoryPanel instance = new StoryPanel();
	int WIDTH = SizeManager.getGlobalWidth();
	int HEIGHT = SizeManager.getGlobalHeight();
	JTextArea MainTextArea;
	JLabel lblName;
	Font font;
	/**
	 * Create the panel.
	 */
	 StoryPanel() {

		TextLoadClass TLC =Manager.getInstance().getTLC();
		try {
			font  = FontMaker.makeFont(new URL("file:resource/irohamaru-Regular.ttf"),30f);


		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		setSize(WIDTH,HEIGHT);
		setLayout(null);

																										MainTextArea = new JTextArea();
																										MainTextArea.setLineWrap(true);
																										MainTextArea.setToolTipText("");
																										MainTextArea.setEditable(false);
																										MainTextArea.setText(TLC.getLines().get(TLC.nowindex));
																										MainTextArea.setFont(font);
																										MainTextArea.setOpaque(false);
																										MainTextArea.setBounds(110, 560, 1059, 160);
																										MainTextArea.setMargin(new Insets(15, 70, 5, 10));
																										MainTextArea.addMouseListener(new PanelClickListener());
																										add(MainTextArea);

																lblName = new JLabel("ましろ");
																lblName.setFont(font);
																lblName.setBounds(110, 518, 120, 48);
																add(lblName);

												JLabel textarea = new JLabel("");
												textarea.setBounds(102, 487, 1148, 200);
												textarea.setIcon(PictureBuilder.resizeIcon(new ImageIcon("resource/icon/textarea.png"), 1148, 400));
												textarea.setOpaque(false);
												add(textarea);

										JLabel label = new JLabel("");


										label.setVerticalAlignment(SwingConstants.BOTTOM);
										label.setHorizontalAlignment(SwingConstants.CENTER);
										label.setIcon(PictureBuilder.resizeIcon(new ImageIcon("resource/BGP/gallery01.jpg"), WIDTH, HEIGHT));
										label.setBounds(0, 0, 1280, 720);
										add(label);

	}

	public static StoryPanel getInstance(){
		return instance;
	}
	public JTextArea getTextArea(){
		return MainTextArea;
	}
	public JLabel getNameLabel(){
		return  lblName;
	}
}

package gameEngine.Window.Panel;

import java.awt.Font;
import java.awt.Insets;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	Font namefont;
	JLabel label;
	/**
	 * Create the panel.
	 */
	 StoryPanel() {

		TextLoadClass TLC =Manager.getInstance().getTLC();
		try {
			font  = FontMaker.makeFont(new URL("file:resource/ipaexg.ttf"),23f);
			namefont  = FontMaker.makeFont(new URL("file:resource/ipaexg.ttf"),30f);

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
																										MainTextArea.setFont(font);
																										MainTextArea.setOpaque(false);
																										MainTextArea.setBounds(110, 540, 1059, 160);
																										MainTextArea.setMargin(new Insets(0, 50, 5, 10));
																										MainTextArea.addMouseListener(new PanelClickListener());
																										MainTextArea.setFocusable(false);
																										add(MainTextArea);

																lblName = new JLabel(System.getProperty("file.encording"));
																lblName.setFont(namefont);
																lblName.setBounds(110, 500, 120, 48);
																add(lblName);


																JButton btnSave = new JButton("Save");
																btnSave.setBounds(666, 695, 117, 29);
																add(btnSave);

																JButton btnLoad = new JButton("Load");
																btnLoad.setBounds(795, 695, 117, 29);
																add(btnLoad);

																JButton btnTitle = new JButton("Title");
																btnTitle.setBounds(924, 695, 117, 29);
																add(btnTitle);
												JLabel textarea = new JLabel("");
												textarea.setBounds(102, 487, 1148, 200);
												textarea.setIcon(PictureBuilder.resizeIcon(new ImageIcon("resource/icon/textarea.png"), 1148, 400));
												textarea.setOpaque(false);
												add(textarea);



										label  = new JLabel("");
										label.setVerticalAlignment(SwingConstants.BOTTOM);
										label.setHorizontalAlignment(SwingConstants.CENTER);
										label.setIcon(PictureBuilder.resizeIcon(new ImageIcon("resource/BGP/gallery01.jpg"), WIDTH, HEIGHT));
										label.setBounds(0, 0, 1280, 720);
										add(label);

	}


	 public JLabel getBGP(){
		 return label;
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

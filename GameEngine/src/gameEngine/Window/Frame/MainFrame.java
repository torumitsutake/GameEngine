package gameEngine.Window.Frame;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Frameclass.PhonePanel;
import gameEngine.Window.Panel.StoryPanel;
import gameEngine.Window.Panel.TopPanel;

public class MainFrame extends JFrame {

	public ArrayList<JPanel> panels = new ArrayList<JPanel>();
	public static MainFrame instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty("file.encording", "UTF-8");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instance  = new MainFrame();

					instance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		TopPanel panel = new TopPanel();
		StoryPanel story = StoryPanel.getInstance();
		PhonePanel PP = new PhonePanel();

		panels.add(panel);
		panels.add(story);
		panels.add(PP);
		panel.setVisible(true);
		story.setVisible(false);
		PP.setVisible(false);
		getContentPane().add(panel);
		getContentPane().add(story);
		 getContentPane().add(SizeManager.Contentresizer(PP, 0.5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295,740);
	}

	public static MainFrame getInstance(){
		return instance;
	}

	public  ArrayList<JPanel> getPanels(){
		return panels;
	}
	public void changePanel(int n){
		for(JPanel p:panels){
			p.setVisible(false);
		}
		panels.get(n).setVisible(true);
		instance.revalidate();
	}


}

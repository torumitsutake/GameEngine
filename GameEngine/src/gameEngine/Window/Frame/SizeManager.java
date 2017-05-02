package gameEngine.Window.Frame;

import java.awt.Component;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import gameEngine.Window.Panel.PictureBuilder;


public class SizeManager {
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;

	public static void changeSize(int w,int h){
		WIDTH = w;
		HEIGHT = h;
	}

	public static int getGlobalWidth(){
		return WIDTH;
	}
	public static int getGlobalHeight(){
		return HEIGHT;
	}

	public static Container Contentresizer(Container con,double multiplies){

		for(Component compon:con.getComponents()){
			compon.setBounds((int) (compon.getX()*multiplies), (int) (compon.getY()*multiplies), (int) (compon.getWidth()*multiplies), (int) (compon.getHeight()*multiplies));
			if(compon instanceof Container){
				SizeManager.Contentresizer((Container)compon,multiplies);
			}

			if(compon instanceof JLabel){
				JLabel BGP = (JLabel)compon;
				Icon icon = BGP.getIcon();
				if(icon != null){
					BGP.setIcon(PictureBuilder.resizeIcon((ImageIcon) icon, BGP.getWidth(), BGP.getHeight()));

				}

			}
			if(compon instanceof JButton){
				JButton button =(JButton)compon;
				Icon icon = button.getIcon();
				if(icon != null){
				button.setIcon(PictureBuilder.resizeIcon((ImageIcon) icon, button.getWidth(), button.getHeight()));
				}
			}

		}


		return con;
	}

}

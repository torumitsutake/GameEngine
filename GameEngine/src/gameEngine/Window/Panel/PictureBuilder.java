package gameEngine.Window.Panel;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class PictureBuilder {
	public static ImageIcon resizeIcon(ImageIcon icon, int w, int h){
		Image CGresize = icon.getImage();
		 BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2 = resizedImg.createGraphics();

		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(CGresize, 0, 0, w, h, null);
		    g2.dispose();
		    ImageIcon resized = new ImageIcon();
		    resized.setImage(resizedImg);
		    return resized;
	}

}

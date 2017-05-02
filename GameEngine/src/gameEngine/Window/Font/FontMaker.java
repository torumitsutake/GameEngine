package gameEngine.Window.Font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FontMaker {
	public static Font makeFont(URL url,float size) {
	    Font font = null;
	    try (InputStream is = url.openStream()) {
	        font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
	    } catch (IOException | FontFormatException ex) {
	        ex.printStackTrace();
	    }
	    return font;
	}

}

package gameEngine.Window.Frame;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class FullScreen {
	public static void setFullScreen(){
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = ge.getDefaultScreenDevice();  // GraphicsDeviceの取得
		if (!device.isFullScreenSupported()) {
            System.out.println("フルスクリーンモードはサポートされていません。");
            return;
        }

		MainFrame.getInstance().setUndecorated(true);
		device.setFullScreenWindow(MainFrame.getInstance());
		setDisplayMode(1280,720,32);


	}

	 public static  void setDisplayMode(int width, int height, int bitDepth) {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 GraphicsDevice device = ge.getDefaultScreenDevice();
	        if (!device.isDisplayChangeSupported()) {
	            System.out.println("ディスプレイモードの変更はサポートされていません。");
	            return;
	        }

	        DisplayMode dm = new DisplayMode(width,height, device.getDisplayMode().getBitDepth(),device.getDisplayMode().getRefreshRate());
	        device.setDisplayMode(dm);
	    }

}

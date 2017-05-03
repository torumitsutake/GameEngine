package gameEngine.Window.Panel;

import gameEngine.Window.Listener.PanelClickListener;

public class TextShowClass extends Thread {
	private static TextShowClass instance = new TextShowClass();


	public static TextShowClass getInstance(){
		if(instance == null){
			instance = new TextShowClass();
		}
		return instance;
	}
	 char data[];
	private boolean alive = true;
	 StoryPanel SP = StoryPanel.getInstance();


	 public void setText(String t){
			data = t.toCharArray();
	 }
	 public void shutdown(){
			PanelClickListener.TSCopen = false;
		this.alive = false;
		System.out.println(alive);
		System.out.println("ThreadShutdown");
		instance = null;
	 }

	@Override
	public void run() {
		int arr_num = data.length;
		PanelClickListener.TSCopen = true;
		for (int i = 0; i <= arr_num-1 && alive; i++) {

			SP.getTextArea().append(String.valueOf(data[i]));

		try {
			this.sleep(20);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		}
		PanelClickListener.TSCopen = false;
		this.alive = false;
		System.out.println(alive);
		System.out.println("ThreadShutdown");
		instance = null;

	}

}

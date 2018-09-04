package edu.umb.cs.cs680.hw02;

public class DrawerClosedNotPlaying implements State {
	private DrawerClosedNotPlaying() {};
	
	private static DrawerClosedNotPlaying instance = null;
	
	public static DrawerClosedNotPlaying getInstance() {
		if (instance == null) { 
			instance = new DrawerClosedNotPlaying();	
		}
		System.out.println("The state is Drawer Closed Not Playing");
		return instance;
	}
	

	@Override
	public void openCloseButtonPushed() {
		System.out.println("Drawer Closed Not Playing, open/close Button pushed");
		player.open();
		player.changeState(DrawerOpen.getInstance());			
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
	}
	
	public String toString() {
		return("DrawerClosedNotPlaying");
	}

}

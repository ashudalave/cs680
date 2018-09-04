package edu.umb.cs.cs680.hw02;

public class DrawerClosedPlaying implements State {
	private DrawerClosedPlaying() {};
	
	private static DrawerClosedPlaying instance = null;
	
	public static DrawerClosedPlaying getInstance() {
		if (instance == null) 
			instance = new DrawerClosedPlaying();
		System.out.println("The state is Drawer Closed  Playing");
		return instance;
	}
	

	@Override
	public void openCloseButtonPushed() {
		
	}

	@Override
	public void playButtonPushed() {
		

	}

	@Override
	public void stopButtonPushed() {
		System.out.println("Drawer Closed Playing, stop  button pushed");
		player.stop();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}
	public String toString() {
		return("DrawerClosedPlaying");
	}

}

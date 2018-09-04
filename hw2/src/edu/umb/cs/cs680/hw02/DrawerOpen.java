package edu.umb.cs.cs680.hw02;

public class DrawerOpen implements State {
private DrawerOpen() {};
	
	private static DrawerOpen instance = null;
	
	public static DrawerOpen getInstance( ) {
		if (instance == null) 
			instance = new DrawerOpen();
		System.out.println("The state is Drawer Open");
		return instance;
	}
	
	@Override
	public void playButtonPushed() {
		System.out.println("Drawer Open, play button pushed");
		player.close();
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());

	}
	@Override
	public void openCloseButtonPushed() {
		System.out.println("Drawer Open, close button pushed");
		player.close();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub

	}
	public String toString() {
		return("DrawerOpen");
	}
}

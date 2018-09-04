package edu.umb.cs.cs680.hw02;

public class DVDPlayer {
	
	private static DVDPlayer instance = null;
	public static State state;
	
	private DVDPlayer() {
	};
	public static DVDPlayer getInstance() {
		if (instance == null) {
			instance = new DVDPlayer();
			state= DrawerClosedNotPlaying.getInstance();
		}
		return instance;
	}
	
	public State changeState(State state) {
		this.state = state;
		return this.state;
	}
	public void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}
	public void playButtonPushed() {
		state.playButtonPushed();
		
	}
	public void stopButtonPushed() {
		state.stopButtonPushed();
	}
	public void open() {
		System.out.println("DVD player opened");
	}
	public void close() {
		System.out.println("DVD player closed");
	}
	public void play() {
		System.out.println("DVD player playing");
	}
	public void stop() {
		System.out.println("DVD player stopped");
	}
	
	public static void main(String args[]) {
		DVDPlayer player = DVDPlayer.getInstance();
		player.changeState(state);
		state.openCloseButtonPushed();
		state.playButtonPushed();
		state.stopButtonPushed();
	}
}

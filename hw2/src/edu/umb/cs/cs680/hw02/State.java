package edu.umb.cs.cs680.hw02;

public interface State {
	
	public DVDPlayer player =DVDPlayer.getInstance();
	public void openCloseButtonPushed();
	public void playButtonPushed();
	public void stopButtonPushed();

}

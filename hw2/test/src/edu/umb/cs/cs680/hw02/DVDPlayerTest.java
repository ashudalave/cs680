/**
 * 
 */
package edu.umb.cs.cs680.hw02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * @author Ashuthosh
 *
 */
public class DVDPlayerTest {
	
	@Test
	public void checkDrawerClosedNotPlayingInstance() {
		DrawerClosedNotPlaying d = DrawerClosedNotPlaying.getInstance();
		assertThat(d.toString(), is("DrawerClosedNotPlaying")); 	
	}
	@Test
	public void checkDrawerClosedPlayingInstance() {
		DrawerClosedPlaying d = DrawerClosedPlaying.getInstance();
		assertThat(d.toString(), is("DrawerClosedPlaying")); 	
	}
	@Test
	public void checkDrawerOpenInstance() {
		DrawerOpen d = DrawerOpen.getInstance();
		assertThat(d.toString(), is("DrawerOpen")); 	
	}
	@Test
	public void checkChangeStateofDrawerOpen() {
		DVDPlayer pl = DVDPlayer.getInstance();
		assertSame(pl.changeState(DrawerOpen.getInstance()),(State) DrawerOpen.getInstance());
	}
	@Test
	public void checkChangeStateofDrawerClosedNotPlaying() {
		DVDPlayer pl = DVDPlayer.getInstance();
		assertSame(pl.changeState(DrawerClosedNotPlaying.getInstance()),(State) DrawerClosedNotPlaying.getInstance());
	}
	@Test
	public void checkChangeStateofDrawerClosedPlaying() {
		DVDPlayer pl = DVDPlayer.getInstance();
		assertSame(pl.changeState(DrawerClosedPlaying.getInstance()),(State) DrawerClosedPlaying.getInstance());
	}
	@Test
	public void testOpenCloseButtonPushed() {
		System.out.println(" ");
		System.out.println("Testing Open Close Button Pushed ");
		DVDPlayer player = DVDPlayer.getInstance();
		player.openCloseButtonPushed();
	}
	@Test
	public void testPlayButtonPushed() {
		System.out.println(" ");
		System.out.println("Testing Play Button Pushed ");
		DVDPlayer player = DVDPlayer.getInstance();
		player.playButtonPushed();
	}
	@Test
	public void testStopButtonPushed() {
		System.out.println(" ");
		System.out.println("Testing Stop Button Pushed ");
		DVDPlayer player = DVDPlayer.getInstance();
		player.stopButtonPushed();
	}
}

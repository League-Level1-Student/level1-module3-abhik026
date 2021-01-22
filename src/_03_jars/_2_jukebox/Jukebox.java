package _03_jars._2_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton again = new JButton();
	JButton pain = new JButton();
	JButton lose = new JButton();
	String againTitle = "See You Again";
	String painTitle = "Sucker For Pain";
	String loseTitle = "Lose Yourself";
	Song first = new Song("Wiz Khalifa - See You Again ft. Charlie Puth [Official Video] Furious 7 Soundtrack.mp3");
	Song second = new Song("Sucker for Pain (with Logic, Ty Dolla $ign & X Ambassadors).mp3");
	Song third = new Song("Lose Yourself.mp3");
	int againClicks = 0;
	int painClicks = 0;
	int loseClicks = 0;

	public void run() {

		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3
		frame.setPreferredSize(new Dimension(650, 150));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		frame.setTitle("Digital Jukebox!");

		panel.add(again);
		panel.add(pain);
		panel.add(lose);

		again.setText(againTitle);
		again.setPreferredSize(new Dimension(150, 40));

		pain.setText(painTitle);
		pain.setPreferredSize(new Dimension(150, 40));

		lose.setText(loseTitle);
		lose.setPreferredSize(new Dimension(150, 40));

		again.addActionListener(this);
		pain.addActionListener(this);
		lose.addActionListener(this);
		frame.pack();

		// 3. Play the Song

		/*
		 * 4. Create a user interface for your Jukebox so that the user can to choose
		 * which song to play. You can use can use a different button for each song, or
		 * a picture of the album cover. When the button or album cover is clicked, stop
		 * the currently playing song, and play the one that was selected.
		 */
	}

	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();

		if (clicked == again) {
			if (againClicks % 2 == 0) {
				first.play();
				againClicks++;
				again.setText("Pause");
				second.stop();
				painClicks = 0;
				pain.setText(painTitle);
				third.stop();
				loseClicks = 0;
				lose.setText(loseTitle);
			} else {
				first.stop();
				againClicks++;
				again.setText("Play");;
			}

		} else if (clicked == pain) {
			if (painClicks % 2 == 0) {
				second.play();
				painClicks++;
				pain.setText("Pause");
				first.stop();
				againClicks = 0;
				again.setText(againTitle);
				third.stop();
				loseClicks = 0;
				lose.setText(loseTitle);
			} else {
				second.stop();
				painClicks++;
				pain.setText("Play");
			}
		} else if (clicked == lose) {
			if (loseClicks % 2 == 0) {
				third.play();
				loseClicks++;
				lose.setText("Pause");
				first.stop();
				againClicks = 0;
				again.setText(againTitle);
				second.stop();
				painClicks = 0;
				pain.setText(painTitle);
				
			} else {
				third.stop();
				loseClicks++;
				lose.setText("Play");
			}
		}

	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

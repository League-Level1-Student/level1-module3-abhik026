package _03_jars._2_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import javax.swing.SwingUtilities;

public class JukeboxRunner {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
		new Jukebox().run();
	}
}

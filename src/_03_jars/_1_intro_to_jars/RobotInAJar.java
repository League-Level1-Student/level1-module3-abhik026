package _03_jars._1_intro_to_jars;


public class RobotInAJar {
	
	/* 1.   Create a String variable and initialize it to your name  */
	
	
	/* If you did not make any syntax errors, there should be no red lines under your code. 
	 * This is because the type String is part of the basic Java language that all programs  
	 * can access without importing anything */
	
	
	/* 2.   Now declare a Robot variable and create a new Robot  */

	
	/* Even if you did not make any syntax errors, there should be a red line under the word Robot.
	 * This is because the type Robot is not part of the basic Java language. If you want to use 
	 * a Robot in your code, you must import the Robot class and all its code.   */

	/* Hover your mouse over the word Robot, and Eclipse should offer you a "quick fix" like this: 
	 * 								Import 'Robot' (java.awt) 
	 * HOWEVER, even though Java has this Robot class (in its java.awt library), 
	 * that is NOT the one we want to use. The League has its own fabulous Robot 
	 * org.jointheleague.graphical.robot.Robot
	 * BUT.... Eclipse did not offer it to you as a "quick fix" because it has not yet 
	 * been built into this project */ 


	 /* 3.  So first we need to get the League's Robot code (from GitHub) */
	  
	 /* The League's Robot code has been packaged into a JAR (Java ARchive) which is like a Zip file.
	  * JARS are used to put all the information a class (or group of classes) needs in a single
	  * (and compressed) file. This makes is easier to share code with other users and programs.
	  * 
	  * Go to https://github.com/jointheleague/league-jars and download the robot.jar file from GitHub
	  */ 

	 /* 4.  Put the Robot JAR into this project */
  	 /* HOW?
	 *  Drag the robot.jar file you downloaded from GitHub and drop it onto Eclipse, onto the current Java project.
	 */
	
	/* 5.  Add the Robot JAR to the project Build Path */	
	/* 
	 * The Robot JAR is in the project, but Eclipse can't use it until it is added to the Build Path.
	 * HOW?
	 * Right click anywhere on the current project. Select Build Path->Configure Build Path from the menu.
	 * Click on the Libraries tab, and select "Add JAR".
	 * Select the robot.jar file, then add it to the build path, apply and close.
	 */
	
	/* 6. Now if you hover your mouse over the word Robot, you will se anew option from the "quick fix" list: 
	 * 				Import 'Robot (org.jointheleague.graphical.robot.Robot)
	 * Select it. If all the red lines have disappeared, you can now complete the draw method below.
	 * Run the program from the RobotInAJarRunner class and a shape should be drawn.
	 */
	
	public void draw() {
		/*** Write code to make your robot draw a shape here ****/
		
		
	}
}

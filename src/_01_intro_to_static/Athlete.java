package _01_intro_to_static;

public class Athlete {
    static int nextBibNumber;
    static String raceLocation = "New York";
    static String raceStartTime = "9.00am";

    String name;
    int speed;
    int bibNumber;

    Athlete (String name, int speed){
        this.name = name;
        this.speed = speed;
    }

    public static void main(String[] args) {
       Athlete sprinter = new Athlete("Sam Malone", 100);
       Athlete runner = new Athlete("Norm Peterson",75);
       System.out.println(sprinter.name);
       System.out.println(runner.name);
       
      
       sprinter.raceLocation = "San Diego";
       System.out.println(runner.raceLocation);
       
       
    	//create two athletes
        //print their names, bibNumbers, and the location of their race. 
    }
}
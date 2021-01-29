package _05_netflix;

public class netflix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie jurrasicPark = new Movie("Jurrasic Park", 4);
		System.out.println(jurrasicPark.getTicketPrice());

		Movie fast = new Movie("Fast & Furious", 2);

		Movie squad = new Movie("Suicide Squad", 3);

		Movie pink = new Movie("Pink Panther", 5);

		Movie ferris = new Movie("Ferris Bueler's Day off", 5);

		NetflixQueue net = new NetflixQueue();
		net.addMovie(jurrasicPark);
		net.addMovie(fast);
		net.addMovie(squad);
		net.addMovie(pink);
		net.addMovie(ferris);

		net.printMovies();
		System.out.println(net.getBestMovie());
		System.out.println(net.getMovie(2));

	}

}

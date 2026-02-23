import java.util.Scanner;

public class MovieDriver_Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//creating Movie Object
		Movie movie = new Movie();
		
		//prompting for title
		System.out.print("Enter the name of the movie: ");
		String title = sc.nextLine();
		movie.setTitle(title);
		
		//prompting for rating
		System.out.print("Enter the rating of the movie:");
		String rating = sc.nextLine();
		movie.setRating(rating);
		
		//prompting for tickets sold
		System.out.print("Enter the amount of tickets sold of the movie:");
		int ticket_sold = sc.nextInt();
		movie.setSoldTickets(ticket_sold);
		
		//print movie information
		System.out.println("Movie Information:");
		System.out.println(movie.toString());
		
		sc.close();
		
		
	}

}

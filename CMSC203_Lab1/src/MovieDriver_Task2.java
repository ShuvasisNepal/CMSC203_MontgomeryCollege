import java.util.Scanner;

public class MovieDriver_Task2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;

        do {

            Movie movie = new Movie();

            System.out.print("Enter the title of a movie: ");
            String title = sc.nextLine();
            movie.setTitle(title);

            System.out.print("Enter the movie's rating: ");
            String rating = sc.nextLine();
            movie.setRating(rating);

            System.out.print("Enter the number of tickets sold: ");
            int soldTickets = sc.nextInt();
            movie.setSoldTickets(soldTickets);

            sc.nextLine();

            System.out.println("Movie Information:");
            System.out.println(movie.toString());

            System.out.print("Do you want to enter another movie? (y/n): ");
            choice = sc.nextLine();

        } while (choice.equalsIgnoreCase("y"));

        sc.close();
    }
}
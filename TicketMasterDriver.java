import java.util.Scanner;
import java.util.ArrayList;  // Import ArrayList

public class TicketMasterDriver {
    private static final int SORT_A_Z = 1;
    private static final int SORT_Z_A = 2;
    private static final int SORT_LOW_HIGH = 3;
    private static final int SORT_HIGH_LOW = 4;
    private static final int SEARCH_CITY = 5;
    private static final int QUIT = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketMaster ticketMaster = new TicketMaster();

        // Load data from the file
        ticketMaster.readShowData("shows.txt");

        int choice;
        do {
            printMenu();
            choice = getUserChoice(scanner);

            if (choice == SORT_A_Z) {
                ticketMaster.sortByPerformer();  // Sort A-Z
                System.out.println("Sorted A-Z:\n" + ticketMaster);
            } else if (choice == SORT_Z_A) {
                ticketMaster.sortByPerformer();  // Sort A-Z
                reverseList(ticketMaster.getShows());  // Reverse for Z-A
                System.out.println("Sorted Z-A:\n" + ticketMaster);
            } else if (choice == SORT_LOW_HIGH) {
                ticketMaster.sortByPrice();  // Sort Low-High
                System.out.println("Sorted Low-High:\n" + ticketMaster);
            } else if (choice == SORT_HIGH_LOW) {
                ticketMaster.sortByPrice();  // Sort Low-High
                reverseList(ticketMaster.getShows());  // Reverse for High-Low
                System.out.println("Sorted High-Low:\n" + ticketMaster);
            } else if (choice == SEARCH_CITY) {
                System.out.print("Enter a city: ");
                String city = scanner.nextLine();
                ArrayList<Show> results = ticketMaster.searchByCity(city);  // Explicit type
                if (results.isEmpty()) {
                    System.out.println("No shows found for the city: " + city);
                } else {
                    System.out.println("Shows in " + city + ":");
                    for (Show show : results) {
                        System.out.println(show);
                    }
                }
            } else if (choice == QUIT) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option. Please choose 1-6.");
            }

        } while (choice != QUIT);

        scanner.close();
    }

    // method to print the menu
    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Sort by Performer A-Z");
        System.out.println("2. Sort by Performer Z-A");
        System.out.println("3. Sort by Price Low-High");
        System.out.println("4. Sort by Price High-Low");
        System.out.println("5. Search by City");
        System.out.println("6. Quit");
        System.out.print("Enter your choice: ");
    }

    // method to get user choice
    private static int getUserChoice(Scanner scanner) {
        int choice = 0;
        while (choice < 1 || choice > 6) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 6) {
                    System.out.print("Please choose a number between 1 and 6: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between 1-6: ");
            }
        }
        return choice;
    }

    // reverseList method using loops
    private static void reverseList(ArrayList<Show> list) {
        // Reverse the list by swapping elements from front to back
        for (int i = 0; i < list.size() / 2; i++) {
            Show temp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, temp);
        }
    }
}

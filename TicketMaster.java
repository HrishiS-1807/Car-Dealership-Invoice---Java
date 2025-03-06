import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles the management of show data including reading data from a file,
 * searching shows by city, and sorting shows by performer or price.
 */
public class TicketMaster {
    // List to store Show objects
    private ArrayList<Show> shows;

    /**
     * Constructor that initializes the shows list.
     */
    public TicketMaster() {
        this.shows = new ArrayList<>();
    }

    /**
     * Reads show data from a file and generates the shows list.
     * 
     * 
     */
    public void readShowData(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            // Read each line in the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Split the line into components
                String[] parts = line.split(" ", 5);

                // Extract and parse the individual parts of the data
                String date = parts[0];
                double price = Double.parseDouble(parts[1]);
                int availableTickets = Integer.parseInt(parts[2]);
                String performerAndCity = parts[3] + " " + parts[4];
                // Split the performer and city into two separate values
                String[] performerCitySplit = performerAndCity.split(", ");
                String performer = performerCitySplit[0];
                String city = performerCitySplit[1];

                // Create a new Show object and add it to the shows list
                shows.add(new Show(date, price, availableTickets, performer, city));
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file cannot be found
            System.err.println("Error: File not found - " + fileName);
        } catch (Exception e) {
            // Handle any other exceptions (e.g., parsing errors)
            System.err.println("Error: Unable to process file - " + e.getMessage());
        }
    }

    /**
     * Gets the list of shows.
     * 
     * return the list of shows
     */
    public ArrayList<Show> getShows() {
        return shows;
    }

    /**
     * Searches for shows by city. This method returns a list of shows that match the given city.
     * 
     * param city the city to search for
     * return a list of shows in the specified city
     */
    public ArrayList<Show> searchByCity(String city) {
        ArrayList<Show> results = new ArrayList<>();
        // Loop through all shows and find those that match the city
        for (Show show : shows) {
            if (show.getCity().equalsIgnoreCase(city)) {
                results.add(show);
            }
        }
        return results;
    }

    /**
     * Sorts the shows list by performer in ascending alphabetical order.
     */
    public void sortByPerformer() {
        // Selection sort algorithm
        for (int i = 0; i < shows.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < shows.size(); j++) {
                // Compare performers alphabetically
                if (shows.get(j).getPerformer().compareTo(shows.get(minIndex).getPerformer()) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements if necessary
            if (minIndex != i) {
                Show temp = shows.get(i);
                shows.set(i, shows.get(minIndex));
                shows.set(minIndex, temp);
            }
        }
    }

    /**
     * Sorts the shows list by price in ascending order.
     */
    public void sortByPrice() {
        // Insertion sort algorithm
        for (int i = 1; i < shows.size(); i++) {
            Show key = shows.get(i);
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            while (j >= 0 && shows.get(j).getPrice() > key.getPrice()) {
                shows.set(j + 1, shows.get(j));
                j--;
            }
            shows.set(j + 1, key);
        }
    }

    /**
     * Returns a string representation of the TicketMaster object.
     * This is useful for printing out the list of shows.
     * 
     * @return a string containing all shows in the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Append each show to the StringBuilder
        for (Show show : shows) {
            sb.append(show).append("\n");
        }
        return sb.toString();
    }
}

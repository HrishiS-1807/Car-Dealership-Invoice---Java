/**
 * Represents a show with details such as date, price, tickets, performer, and city.
 */
public class Show {
    private String date;
    private double price;
    private int availableTickets;
    private String performer;
    private String city;

    /**
     * Creates a new Show.
     *
     * The date of the show.
     * The ticket price.
     * The number of tickets available.
     * The performer of the show.
     * The city of the show.
     */
    public Show(String date, double price, int availableTickets, String performer, String city) {
        this.date = date;
        this.price = price;
        this.availableTickets = availableTickets;
        this.performer = performer;
        this.city = city;
    }

    /**
     * Returns the date of the show.
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the price of the ticket.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the number of tickets available.
     */
    public int getAvailableTickets() {
        return availableTickets;
    }

    /**
     * Returns the name of the performer.
     */
    public String getPerformer() {
        return performer;
    }

    /**
     * Returns the city of the show.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns a formatted string with show details.
     */
    @Override
    public String toString() {
        return String.format("%-10s $%-8.2f %-5d %-20s %s", date, price, availableTickets, performer, city);
    }
}

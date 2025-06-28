class TicketCounter {
    private int availableTickets = 5;

    public synchronized void bookTicket(String name, int numberOfTickets) {
        System.out.println(name + " is trying to book " + numberOfTickets + " ticket(s).");

        if (numberOfTickets <= availableTickets) {
            System.out.println("Tickets available. Booking for " + name + "...");
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                System.out.println("Booking interrupted");
            }
            availableTickets -= numberOfTickets;
            System.out.println("Booking successful for " + name + ". Tickets left: " + availableTickets);
        } else {
            System.out.println("Not enough tickets for " + name + ". Booking failed.");
        }
    }
}
class BookingThread extends Thread {
    private final TicketCounter counter;
    private final String user;
    private final int ticketsToBook;

    public BookingThread(TicketCounter counter, String user, int ticketsToBook) {
        this.counter = counter;
        this.user = user;
        this.ticketsToBook = ticketsToBook;
    }

    public void run() {
        counter.bookTicket(user, ticketsToBook);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        BookingThread t1 = new BookingThread(counter, "Anna", 2);
        BookingThread t2 = new BookingThread(counter, "Raj", 3);
        BookingThread t3 = new BookingThread(counter, "Simran", 2); 

        t1.start();
        t2.start();
        t3.start();
    }
}

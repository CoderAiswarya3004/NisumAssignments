import java.util.*;

class Schedule {
    String heading;
    String timing;
    String info;

    public Schedule(String heading, String timing, String info) {
        this.heading = heading;
        this.timing = timing;
        this.info = info;
    }

    public String toString() {
        return "Title: " + heading + ", Time: " + timing + ", Note: " + info;
    }
}

public class EventPlanner {

    static TreeMap<String, List<Schedule>> agenda = new TreeMap<>();

    static void createEvent(String date, String heading, String timing, String info) {
        Schedule entry = new Schedule(heading, timing, info);
        agenda.putIfAbsent(date, new ArrayList<>());
        agenda.get(date).add(entry);
        System.out.println("Event recorded on " + date);
    }

    static void cancelEvent(String date, String heading) {
        if (agenda.containsKey(date)) {
            boolean found = agenda.get(date).removeIf(e -> e.heading.equalsIgnoreCase(heading));
            if (found) {
                System.out.println("Event cancelled.");
            } else {
                System.out.println("No event with that title found on " + date);
            }
        } else {
            System.out.println("No events exist for " + date);
        }
    }

    static void showDateWise(String date) {
        if (agenda.containsKey(date)) {
            System.out.println("Schedule for " + date + ":");
            for (Schedule s : agenda.get(date)) {
                System.out.println(s);
            }
        } else {
            System.out.println("Nothing planned for this date.");
        }
    }

    static void showAllUpcoming() {
        if (agenda.isEmpty()) {
            System.out.println("No events planned ahead.");
            return;
        }

        System.out.println("\n=== Upcoming Plans ===");
        for (Map.Entry<String, List<Schedule>> plan : agenda.entrySet()) {
            System.out.println("\nDate: " + plan.getKey());
            for (Schedule s : plan.getValue()) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("\n-- Event Manager Menu --");
            System.out.println("1. Add New Event");
            System.out.println("2. Delete Event");
            System.out.println("3. View Events by Date");
            System.out.println("4. View All Upcoming Events");
            System.out.println("5. Exit");
            System.out.print("Choose (1–5): ");
            input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.print("Date (YYYY-MM-DD): ");
                    String d1 = sc.nextLine();
                    System.out.print("Title: ");
                    String t1 = sc.nextLine();
                    System.out.print("Time: ");
                    String tm = sc.nextLine();
                    System.out.print("Description: ");
                    String ds = sc.nextLine();
                    createEvent(d1, t1, tm, ds);
                    break;

                case 2:
                    System.out.print("Date (YYYY-MM-DD): ");
                    String d2 = sc.nextLine();
                    System.out.print("Event title to remove: ");
                    String t2 = sc.nextLine();
                    cancelEvent(d2, t2);
                    break;

                case 3:
                    System.out.print("Date (YYYY-MM-DD): ");
                    String d3 = sc.nextLine();
                    showDateWise(d3);
                    break;

                case 4:
                    showAllUpcoming();
                    break;

                case 5:
                    System.out.println("Calendar closed.");
                    break;

                default:
                    System.out.println("Enter a valid option.");
            }

        } while (input != 5);

        sc.close();
    }
}

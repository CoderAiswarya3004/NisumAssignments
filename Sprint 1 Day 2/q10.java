import java.util.*;

class Film {
    String name;
    String maker;
    String type;
    int year;
    double score;

    public Film(String name, String maker, String type, int year, double score) {
        this.name = name;
        this.maker = maker;
        this.type = type;
        this.year = year;
        this.score = score;
    }

    public String toString() {
        return String.format("| %-25s | %-15s | %-10s | %-12d | %-6.1f |",
                name, maker, type, year, score);
    }
}

public class MovieLibrary {

    static ArrayList<Film> list = new ArrayList<>();

    static void insertFilm(String name, String maker, String type, int year, double score) {
        list.add(new Film(name, maker, type, year, score));
        System.out.println("Movie added.");
    }

    static void deleteFilm(String name) {
        boolean removed = list.removeIf(f -> f.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Movie removed.");
        } else {
            System.out.println("No such movie found.");
        }
    }

    static void filterByType(String type) {
        System.out.println("\nMovies of genre: " + type);
        for (Film f : list) {
            if (f.type.equalsIgnoreCase(type)) {
                System.out.println(f);
            }
        }
    }

    static void filterByMaker(String maker) {
        System.out.println("\nDirected by: " + maker);
        for (Film f : list) {
            if (f.maker.equalsIgnoreCase(maker)) {
                System.out.println(f);
            }
        }
    }

    static void filterByYear(int y) {
        System.out.println("\nReleased in " + y + ":");
        for (Film f : list) {
            if (f.year == y) {
                System.out.println(f);
            }
        }
    }

    static void arrangeByTitle() {
        list.sort(Comparator.comparing(f -> f.name));
        showAll();
    }

    static void arrangeByYear() {
        list.sort(Comparator.comparingInt(f -> f.year));
        showAll();
    }

    static void arrangeByScore() {
        list.sort(Comparator.comparingDouble(f -> f.score));
        showAll();
    }

    static void showAll() {
        System.out.println("\n--- Film Library ---");
        System.out.println("| Title                   | Director       | Genre     | Year        | Rating |");
        System.out.println("|-------------------------|----------------|-----------|-------------|--------|");
        for (Film f : list) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Movie Menu ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. View All");
            System.out.println("4. Filter by Genre");
            System.out.println("5. Filter by Director");
            System.out.println("6. Filter by Year");
            System.out.println("7. Sort by Title");
            System.out.println("8. Sort by Year");
            System.out.println("9. Sort by Rating");
            System.out.println("10. Exit");
            System.out.print("Enter option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String name = input.nextLine();
                    System.out.print("Director: ");
                    String maker = input.nextLine();
                    System.out.print("Genre: ");
                    String type = input.nextLine();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    System.out.print("Rating (0.0–10.0): ");
                    double score = input.nextDouble();
                    insertFilm(name, maker, type, year, score);
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    String delName = input.nextLine();
                    deleteFilm(delName);
                    break;

                case 3:
                    showAll();
                    break;

                case 4:
                    System.out.print("Genre: ");
                    String g = input.nextLine();
                    filterByType(g);
                    break;

                case 5:
                    System.out.print("Director: ");
                    String d = input.nextLine();
                    filterByMaker(d);
                    break;

                case 6:
                    System.out.print("Year: ");
                    int y = input.nextInt();
                    filterByYear(y);
                    break;

                case 7:
                    arrangeByTitle();
                    break;

                case 8:
                    arrangeByYear();
                    break;

                case 9:
                    arrangeByScore();
                    break;

                case 10:
                    System.out.println("Library closed.");
                    break;

                default:
                    System.out.println("Invalid selection.");
            }

        } while (choice != 10);

        input.close();
    }
}

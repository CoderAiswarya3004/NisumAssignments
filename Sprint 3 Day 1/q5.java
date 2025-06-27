import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;

public class MultiCatchExample {

    public static void readAndParseIntegers(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                System.out.println("Parsed integer: " + number);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error while reading or parsing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readAndParseIntegers("numbers.txt");
    }
}


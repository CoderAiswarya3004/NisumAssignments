import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidatorWithFile {

    public static void validateAge(int age) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("age_output.txt", true))) {
            if (age <= 0) {
                throw new InvalidAgeException("Invalid age: " + age);
            }
            writer.println("Valid age: " + age);
            System.out.println("Age logged to file: " + age);
        } catch (InvalidAgeException e) {
            System.out.println("Custom exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        validateAge(23);
        validateAge(-7);
        validateAge(0);
    }
}

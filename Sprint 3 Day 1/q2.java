class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {

    public static void validateAge(int age) {
        if (age <= 0) {
            throw new InvalidAgeException("Invalid age: " + age + ". Age must be greater than zero.");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(25);   // Valid
            validateAge(-5);   // Invalid, triggers exception
            validateAge(0);    // Invalid, triggers exception
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught general exception: " + e.getMessage());
        }
    }
}

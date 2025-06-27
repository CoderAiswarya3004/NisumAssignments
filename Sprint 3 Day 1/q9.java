import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class ValidationException extends Exception {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        super("Validation failed with multiple errors.");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}

class ValidationRule<T> {
    private final Predicate<T> rule;
    private final String errorMessage;

    public ValidationRule(Predicate<T> rule, String errorMessage) {
        this.rule = rule;
        this.errorMessage = errorMessage;
    }

    public boolean isValid(T value) {
        return rule.test(value);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

class User {
    String name;
    Integer age;

    User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
class Validator {

    public static void validateUser(User user) throws ValidationException {
        List<String> errors = new ArrayList<>();

        List<ValidationRule<User>> rules = new ArrayList<>();
        rules.add(new ValidationRule<>(u -> u.name != null && !u.name.isEmpty(), "Name cannot be null or empty."));
        rules.add(new ValidationRule<>(u -> u.age != null && u.age > 0, "Age must be positive."));

        for (ValidationRule<User> rule : rules) {
            if (!rule.isValid(user)) {
                errors.add(rule.getErrorMessage());
            }
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
public class ValidationFramework {
    public static void main(String[] args) {
        User validUser = new User("Anna", 22);
        User invalidUser = new User("", -5);

        try {
            Validator.validateUser(validUser);
            System.out.println("✅ Valid user passed validation.");
        } catch (ValidationException e) {
            System.out.println("❌ Errors in validUser: " + e.getErrors());
        }

        try {
            Validator.validateUser(invalidUser);
        } catch (ValidationException e) {
            System.out.println("❌ Errors in invalidUser:");
            for (String err : e.getErrors()) {
                System.out.println(" - " + err);
            }
        }
    }
}

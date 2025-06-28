class BusinessException extends Exception {
    public BusinessException(String message) {
        super(message);
    }
}

class UserRepository {
    public void getUserById(int id) throws BusinessException {
        if (id <= 0) {
            throw new BusinessException("Invalid user ID: " + id);
        }
        System.out.println("Fetching user with ID: " + id);
    }
}

class UserService {
    private final UserRepository repository = new UserRepository();

    public void processUser(int id) throws BusinessException {
        repository.getUserById(id);
        System.out.println("Processing user with ID: " + id);
    }
}

public class LayeredExceptionHandling {

    public static void main(String[] args) {
        UserService service = new UserService();

        try {
            service.processUser(-1); 
        } catch (BusinessException e) {
            System.out.println("❌ Caught in Controller: " + e.getMessage());
        }
    }
}

import org.springframework.stereotype.Component;

@Component
public class BusinessService {
    public void serve() {
        System.out.println("Business logic started...");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Business logic finished.");
    }
}

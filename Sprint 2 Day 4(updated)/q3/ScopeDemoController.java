import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeDemoController {

    @Autowired
    private RequestScopedBean requestBean;

    @Autowired
    private SessionScopedBean sessionBean;

    @GetMapping("/test-scope")
    public String checkScope() {
        return "Request and Session bean log printed in console.";
    }
}

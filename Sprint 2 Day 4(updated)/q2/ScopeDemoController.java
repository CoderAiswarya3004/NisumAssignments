import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

    @Autowired
    private RequestScopedBean requestBean;

    @Autowired
    private SessionScopedBean sessionBean;

    @GetMapping("/scope-test")
    public String testScopes() {
        return "Check console for scope bean logs.";
    }
}

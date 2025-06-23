import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SessionScopedBean {
    public SessionScopedBean() {
        System.out.println("SessionScopedBean created");
    }
}

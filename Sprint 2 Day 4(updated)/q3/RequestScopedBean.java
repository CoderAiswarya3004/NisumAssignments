import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestScopedBean {
    public RequestScopedBean() {
        System.out.println("RequestScopedBean created");
    }
}

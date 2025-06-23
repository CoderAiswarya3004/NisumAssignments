import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* BusinessService.process(..))")
    public void logBefore() {
        System.out.println("Logging BEFORE method execution: BusinessService.process()");
    }
}

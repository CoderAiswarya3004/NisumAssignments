import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonBean sb1 = context.getBean("singletonBean", SingletonBean.class);
        SingletonBean sb2 = context.getBean("singletonBean", SingletonBean.class);

        PrototypeBean pb1 = context.getBean("prototypeBean", PrototypeBean.class);
        PrototypeBean pb2 = context.getBean("prototypeBean", PrototypeBean.class);
    }
}

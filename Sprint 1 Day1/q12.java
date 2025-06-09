public class StaticInstanceCheck {

    int instanceVar = 25;

    static void staticMethod() {
        StaticInstanceCheck obj = new StaticInstanceCheck();
        System.out.println("Accessing instance variable via object: " + obj.instanceVar);
    }

    public static void main(String[] args) {
        staticMethod();
    }
}

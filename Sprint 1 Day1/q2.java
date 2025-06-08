class Base {
    public String publicVar = "Public Variable";
    private String privateVar = "Private Variable";
    protected String protectedVar = "Protected Variable";
    String defaultVar = "Default Variable"; 
     static {
        System.out.println("Static block in Base class executed.");
    }
    public void show() {
        System.out.println("Inside Base class");
        System.out.println(publicVar);
        System.out.println(privateVar);
        System.out.println(protectedVar);
        System.out.println(defaultVar);
    }
}
class Derived extends Base {
    static {
        System.out.println("Static block in Derived class executed.");
    }
    public void display() {
        System.out.println("Inside Derived class");
        System.out.println(publicVar);
        System.out.println(protectedVar);
        System.out.println(defaultVar);
    }
}

public class CoreJavaConceptsDemo {
    public static void main(String[] args) {
        Derived obj = new Derived();
        obj.show();     
        obj.display();  
    }
}

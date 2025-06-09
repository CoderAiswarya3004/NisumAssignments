class Parent {
    public static void displayMessage() {
        System.out.println("Message from Parent class static method.");
    }
}

class Child extends Parent {
    public static void callParentMethod() {
        Parent.displayMessage(); 
    }
}

public class StaticMethodAccess{
    public static void main(String[] args) {
        Child.callParentMethod();
    }
}

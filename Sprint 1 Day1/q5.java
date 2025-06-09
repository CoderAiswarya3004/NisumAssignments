class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class MethodOverriding{
    public static void main(String[] args) {
        Animal a1 = new Dog(); 
        Animal a2 = new Cat();

        a1.makeSound(); 
        a2.makeSound();  
    }
}

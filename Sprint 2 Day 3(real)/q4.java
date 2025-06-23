class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    private Engine engine;

    // Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("Constructor Injection used.");
    }

    // Setter Injection
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("Setter Injection used.");
    }

    public void drive() {
        engine.start();
        System.out.println("Car is running...");
    }

    public static void main(String[] args) {
        // Constructor Injection
        Engine engine1 = new Engine();
        Car car1 = new Car(engine1);
        car1.drive();

        // Setter Injection
        Engine engine2 = new Engine();
        Car car2 = new Car(null);  
        car2.setEngine(engine2);
        car2.drive();
    }
}

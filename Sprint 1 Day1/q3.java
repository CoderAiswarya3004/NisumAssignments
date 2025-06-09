class Vehicle {
    String brand;
    String model;
    int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    int seatingCapacity;

    public Car(String brand, String model, int year, int seatingCapacity) {
        super(brand, model, year);
        this.seatingCapacity = seatingCapacity;
    }

    public void displayCarInfo() {
        System.out.println("Car Information:");
        displayInfo();
        System.out.println("Seating Capacity: " + seatingCapacity);
        System.out.println();
    }
}

class Bus extends Vehicle {
    String routeNumber;

    public Bus(String brand, String model, int year, String routeNumber) {
        super(brand, model, year);
        this.routeNumber = routeNumber;
    }

    public void displayBusInfo() {
        System.out.println("Bus Information:");
        displayInfo();
        System.out.println("Route Number: " + routeNumber);
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2021, 5);
        Bus bus = new Bus("Volvo", "9400", 2018, "B-42");

        car.displayCarInfo();
        bus.displayBusInfo();
    }
}

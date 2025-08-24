package polymorphism;

/**
 *
 * Name: Agbai Obasi Uwa
 * Registration number: 20231411752
 * Department: Computer Science
 * Group No: 1
 * S/N: 7
 */
public class POLYMORPHISM {

    // Base class
    static class Vehicle {
        protected String brand;
        protected String model;

        public Vehicle(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        // Polymorphic method
        public void startEngine() {
            System.out.println("Vehicle engine starting...");
        }

        public String vehicleInfo() {
            return brand + " " + model;
        }
    }

    // Derived class 1
    static class Car extends Vehicle {
        private int doors;

        public Car(String brand, String model, int doors) {
            super(brand, model);
            this.doors = doors;
        }

        @Override
        public void startEngine() {
            System.out.println(vehicleInfo() + " (Car) engine starts with a key or push button.");
        }

        @Override
        public String vehicleInfo() {
            return super.vehicleInfo() + " - Car with " + doors + " doors";
        }
    }

    // Derived class 2
    static class Motorcycle extends Vehicle {
        private boolean hasSidecar;

        public Motorcycle(String brand, String model, boolean hasSidecar) {
            super(brand, model);
            this.hasSidecar = hasSidecar;
        }

        @Override
        public void startEngine() {
            System.out.println(vehicleInfo() + " (Motorcycle) engine starts with a kick or button.");
        }

        @Override
        public String vehicleInfo() {
            String sidecarInfo = hasSidecar ? "with sidecar" : "without sidecar";
            return super.vehicleInfo() + " - Motorcycle " + sidecarInfo;
        }
    }

    // Main method
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Toyota", "Camry", 4),
            new Motorcycle("Harley-Davidson", "Street 750", true),
            new Car("Tesla", "Model 3", 4),
            new Motorcycle("Yamaha", "R1", false)
        };

        // Demonstrating polymorphism
        for (Vehicle v : vehicles) {
            v.startEngine(); // Runs the overridden method depending on object type
        }
    }
}


/*Output*
 *Toyota Camry - Car with 4 doors (Car) engine starts with a key or push button.
 *Harley-Davidson Street 750 - Motorcycle with sidecar (Motorcycle) engine starts with a kick or button.
 *Tesla Model 3 - Car with 4 doors (Car) engine starts with a key or push button.
 *Yamaha R1 - Motorcycle without sidecar (Motorcycle) engine starts with a kick or button.
 */
// FactoryPattern.java - Java Learning File


// product interface
interface Car {
    void drive();
}

// concrete product classes
class Sedan implements Car {
    public void drive() {
        System.out.println("Driving a sedan");
    }
}

class SUV implements Car {
    public void drive() {
        System.out.println("Driving an SUV");
    }
}

// factory class
class CarFactory {
    public static Car getCar(String type) {
        if (type.equals("sedan")) {
            return new Sedan();
        } else if (type.equals("suv")) {
            return new SUV();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Car sedan = CarFactory.getCar("sedan");
        sedan.drive();
    }
}
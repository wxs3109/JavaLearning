// Polymorphism.java - Java Learning File
// Superclass
class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }

    public void move() {
        System.out.println("Animal moves");
    }

    public static void staticInfo() {
        System.out.println("Animal static info");
    }
}

// Subclass 1
class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog barks");
    }

    @Override
    public void move() {
        System.out.println("Dog runs");
    }

    public static void staticInfo() {
        System.out.println("Dog static info");
    }
}

// Subclass 2
class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Cat meows");
    }

    @Override
    public void move() {
        System.out.println("Cat jumps");
    }

    public static void staticInfo() {
        System.out.println("Cat static info");
    }
}

// Main test class
public class PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("=== Polymorphic Method Calls ===");
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.speak();  // Dog barks
        a1.move();   // Dog runs

        a2.speak();  // Cat meows
        a2.move();   // Cat jumps

        System.out.println("\n=== Static Method Calls (no polymorphism) ===");
        a1.staticInfo(); // Animal static info
        a2.staticInfo(); // Animal static info
        Dog.staticInfo(); // Dog static info
        Cat.staticInfo(); // Cat static info
    }
}

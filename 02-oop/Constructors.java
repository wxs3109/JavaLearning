public class Constructors {
    private String name;
    private int age;
    private String address;

    // Default constructor
    public Constructors() {
        this.name = "Unknown";
        this.age = 0;
        this.address = "Not specified";
    }

    // Parameterized constructor
    public Constructors(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "Not specified";
    }

    // Constructor overloading with different parameters
    public Constructors(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Copy constructor
    public Constructors(Constructors other) {
        this.name = other.name;
        this.age = other.age;
        this.address = other.address;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public static void main(String[] args) {
        // Using different constructors
        Constructors person1 = new Constructors();  // Default constructor
        Constructors person2 = new Constructors("John", 25);  // Two-parameter constructor
        Constructors person3 = new Constructors("Alice", 30, "New York");  // Three-parameter constructor
        Constructors person4 = new Constructors(person3);  // Copy constructor

        System.out.println("Person 1 (Default):");
        person1.display();
        
        System.out.println("\nPerson 2 (Two parameters):");
        person2.display();
        
        System.out.println("\nPerson 3 (Three parameters):");
        person3.display();
        
        System.out.println("\nPerson 4 (Copy of Person 3):");
        person4.display();
    }
} 
public class StaticVsInstance {
    // Static variable (class-level)
    private static int totalStudents = 0;
    
    // Instance variables (object-level)
    private String name;
    private int id;
    
    // Static block
    static {
        System.out.println("Static block executed when class is loaded");
    }
    
    // Constructor
    public StaticVsInstance(String name) {
        this.name = name;
        this.id = ++totalStudents;  // Incrementing static variable
    }
    
    // Static method
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    // Instance method
    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
    }
    
    public static void main(String[] args) {
        // Creating instances
        StaticVsInstance student1 = new StaticVsInstance("John");
        StaticVsInstance student2 = new StaticVsInstance("Alice");
        StaticVsInstance student3 = new StaticVsInstance("Bob");
        
        // Displaying instance information
        System.out.println("Student 1:");
        student1.displayInfo();
        
        System.out.println("\nStudent 2:");
        student2.displayInfo();
        
        System.out.println("\nStudent 3:");
        student3.displayInfo();
        
        // Accessing static method
        System.out.println("\nTotal Students: " + StaticVsInstance.getTotalStudents());
        
        // Demonstrating static variable is shared
        System.out.println("\nAccessing totalStudents through different instances:");
        System.out.println("Student1 total: " + student1.getTotalStudents());
        System.out.println("Student2 total: " + student2.getTotalStudents());
        System.out.println("Student3 total: " + student3.getTotalStudents());
    }
} 
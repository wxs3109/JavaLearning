// GarbageCollectionDemo.java - Java Learning File
// What is garbage collection?
// 1. Automatically frees memory by destroying unreachable objects
// 2. Helps prevent memory leaks
// 3. Runs in background using JVM's GC thread
// 4. No need for manual memory deallocation like in C/C++

public class GarbageCollectionDemo {
    public static void main(String[] args) {
        // Create objects
        Person person1 = new Person("John", 20);
        Person person2 = new Person("Jane", 21);
        Person person3 = new Person("Jim", 22);

        // Nullify references
        person1 = null;
        person2 = null;

        // Suggest JVM to run Garbage Collector
        System.gc();

        System.out.println("End of main method");
    }

    // finalize() is deprecated in Java 9+, but shown here for educational purposes
    @Override
    protected void finalize() throws Throwable {
        System.out.println("GarbageCollectorDemo object is being garbage collected");
    }
}

// Simple class with finalize() to demonstrate GC (not recommended in production)
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " is being garbage collected");
    }
}

class Person implements Cloneable {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // toString() method override
    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
    
    // equals() method override
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Person other = (Person) obj;
        return age == other.age && 
               (name == null ? other.name == null : name.equals(other.name));
    }
    
    // hashCode() method override
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
    
    // clone() method override
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // finalize() method override (deprecated in Java 9+)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + this);
        super.finalize();
    }
}

public class ObjectClassMethods {
    public static void main(String[] args) {
        try {
            // Creating objects
            Person person1 = new Person("John", 25);
            Person person2 = new Person("John", 25);
            Person person3 = new Person("Alice", 30);
            
            // toString() demonstration
            System.out.println("toString() demonstration:");
            System.out.println("person1: " + person1);
            System.out.println("person2: " + person2);
            System.out.println("person3: " + person3);
            
            // equals() demonstration
            System.out.println("\nequals() demonstration:");
            System.out.println("person1.equals(person2): " + person1.equals(person2));
            System.out.println("person1.equals(person3): " + person1.equals(person3));
            
            // hashCode() demonstration
            System.out.println("\nhashCode() demonstration:");
            System.out.println("person1 hashCode: " + person1.hashCode());
            System.out.println("person2 hashCode: " + person2.hashCode());
            System.out.println("person3 hashCode: " + person3.hashCode());
            
            // clone() demonstration
            System.out.println("\nclone() demonstration:");
            Person clonedPerson = (Person) person1.clone();
            System.out.println("Original: " + person1);
            System.out.println("Cloned: " + clonedPerson);
            System.out.println("Original == Cloned: " + (person1 == clonedPerson));
            System.out.println("Original.equals(Cloned): " + person1.equals(clonedPerson));
            
            // getClass() demonstration
            System.out.println("\ngetClass() demonstration:");
            System.out.println("person1 class: " + person1.getClass().getName());
            
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
} 
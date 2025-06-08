// ClassesAndObjects.java - Java Learning File
public class Person {

    private int age;
    private String name;

        // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    // custom getter and setter
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }   

    // to string method
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    // main method
    public static void main(String[] args) {
        Person person = new Person("John", 20);
        System.out.println(person);
    }
}
class Parent {
    protected String name;
    protected int age;

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Parent - Name: " + name + ", Age: " + age);
    }
}

class Child extends Parent {
    private String school;

    public Child(String name, int age, String school) {
        super(name, age);  // Calling parent constructor
        this.school = school;
    }

    public void display() {
        super.display();  // Calling parent method
        System.out.println("Child - School: " + school);
    }

    public void setSchool(String school) {
        this.school = school;  // Using this to refer to current object
    }
}

public class ThisAndSuper {
    public static void main(String[] args) {
        // what would be the output of the following code?
        // Parent - Name: John, Age: 15? why parent constructor is called?
        Child child = new Child("John", 15, "High School");
        child.display();
        
        // Using this in method
        child.setSchool("New School");
        child.display();
    }
} 
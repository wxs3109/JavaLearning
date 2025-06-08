public class AbstractClassDemo {
    public static void main(String[] args) {
       // Animal animal = new Animal(); // cannot instantiate an abstract class
       Animal animal = new Dog();
       animal.eat();
    }
}


abstract class Animal {
    public abstract void eat();
}

class Dog extends Animal {
    public void eat() {
        System.out.println("Dog is eating");
    }
}
// Interfaces.java - Java Learning File


class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird extends Animal implements Flyable {
    public void fly() {
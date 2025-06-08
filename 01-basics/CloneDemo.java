public class CloneDemo {
    public static void main(String[] args) {
        Person person = new Person("John", 20);
        Person person2 = person.clone();
        System.out.println(person2.getName());
        System.out.println(person2.getAge());
    }
}

public class OverloadDemo {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
        System.out.println(add(1, 2, 3, 4, 5,6.5, 7.5, 8.5, 9.5, 10.5));
    }

    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // add numerous int 
    public static int add(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // use generic method to add numerous numbers
    // can it use both int and double? yes
    // besides extends Numbrers, what else can be used?
    // 1. extends Number
    // 2. extends Object
    // 3. extends Serializable
    // 4. extends Comparable
    // 5. extends Cloneable
    // 6. extends AutoCloseable
    public static <T extends Number> double add(T... numbers) {
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}

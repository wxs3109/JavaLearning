// lambda expression is a way to create anonymous functions
// it is a way to create anonymous functions
// it is a way to create anonymous functions

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        // lambda expression to create a thread
        Thread thread = new Thread(() -> System.out.println("Thread running"));
        thread.start();
    }
    // lambda for stream pipeline
    public static void streamPipeline() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .forEach(System.out::println);
    }
}

// labmda for stream pipeline
// ControlFlow.java - Java Learning File

public class ControlFlow {
    public static void main(String[] args) {
        int x = 10;
        if (x > 5) {
            System.out.println("x is greater than 5");
        }
    }

    public static void loopDemo() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void whileLoopDemo() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
    }

    public static void forEachLoopDemo() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void switchDemo() {
        int x = 1;
        switch (x) {
            case 1:
                System.out.println("x is 1");
                break;
        }
    }
}
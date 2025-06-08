import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        failFastIterator();
    }

    // fail-fast iterator
    public static void failFastIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i : list) {
            System.out.println(i);
            list.add(4);
        }
    }
}

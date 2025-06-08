// CollectionsDemo.java - Java Learning File

// import arraylist
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;


public class CollectionsDemo {
    public static void main(String[] args) {
        // arraylist
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);
    }

    public static void arrayListDemo() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void linkedListDemo() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }
        // the running time of contains is O(n)
        if (list.contains("Hello")) {
            System.out.println("Hello is in the list");
        }
    }

    public static void hashSetDemo() {
        HashSet<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        boolean contains = set.contains("Hello"); // running time is O(1)
        System.out.println(contains);
        set.remove("Hello"); // running time is O(1)
        System.out.println(set);
        set.clear(); // running time is O(1)
        System.out.println(set);
        // the running time of size is O(1)
        System.out.println(set.size());
    }

    public static void hashMapDemo() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Hello", 1);
        map.put("World", 2);
        System.out.println(map);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
        for (Integer i : map.values()) {
            System.out.println(i);
        }
        // is map for polymorphism? yes
        // is map for inheritance? yes
        // is map for abstraction? yes
        // is map for encapsulation? yes
        // is map for polymorphism? yes
        // is map for inheritance? yes
        // is map for abstraction? yes
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        map.remove(map.keySet().iterator().next());
    }
}
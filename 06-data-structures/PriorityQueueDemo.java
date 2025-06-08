import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(20);
        pq.add(30);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

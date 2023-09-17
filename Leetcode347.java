import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347 {
    public static void main(String[] args) {
        int[] test = new int[]{
                1, 1, 1, 2, 2, 3
        };

        int[] ints = topKFrequent(test, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] tmp = new int[]{entry.getKey(), entry.getValue()};
            priorityQueue.offer(tmp);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }

        return result;
    }
}

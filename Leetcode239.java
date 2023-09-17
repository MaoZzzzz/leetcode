import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode239 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 1, 2, 0, 5};

        int[] res = maxSlidingWindow(test, 3);
        for (int r : res) {
            System.out.println(r);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int index = 0;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.poll();
            }

            queue.offer(nums[i]);
            if (i >= k - 1) {
                result[index++] = nums[queue.peek()];
            }
        }
        return result;
    }
}

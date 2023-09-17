import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode559 {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        return digui(root);
    }

    private int digui(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        for (Node nodeTmp : root.children) {
            int childDepth = digui(nodeTmp);
            depth = Math.max(depth, childDepth);
        }

        return depth + 1;
    }

    private int cengxu(Node root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            result++;
            int len = queue.size();
            while (len > 0) {
                Node poll = queue.poll();
                if (!poll.children.isEmpty()) {
                    poll.children.forEach(queue::offer);
                }
                len--;
            }
        }

        return result;
    }
}

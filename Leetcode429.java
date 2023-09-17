import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (len > 0) {
                Node nodeTmp = queue.poll();
                tmp.add(nodeTmp.val);
                if (nodeTmp.children.size() != 0) {
                    for (Node node : nodeTmp.children) {
                        queue.offer(node);
                    }
                }
                len--;
            }
            result.add(tmp);
        }

        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return digui(root);
    }

    private int cengxu(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            result++;
            int len = queue.size();
            while (len > 0) {
                TreeNode treeNodeTmp = queue.poll();
                if (treeNodeTmp.left != null) {
                    queue.offer(treeNodeTmp.left);
                }
                if (treeNodeTmp.right != null) {
                    queue.offer(treeNodeTmp.right);
                }
                len--;
            }
        }

        return result;
    }

    private int digui (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = digui(root.left);
        int right = digui(root.right);
        int depth = Math.max(left, right) + 1;

        return depth;
    }
}

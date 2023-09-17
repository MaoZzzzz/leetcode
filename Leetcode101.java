import java.util.LinkedList;
import java.util.Queue;

public class Leetcode101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compareD(root);
    }

    private boolean compareD(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftTmp = queue.poll();
            TreeNode rightTmp = queue.poll();
            if (leftTmp == null && rightTmp == null) {
                continue;
            }
            if (leftTmp == null || rightTmp == null || leftTmp.val != rightTmp.val) {
                return false;
            }
            queue.offer(leftTmp.left);
            queue.offer(rightTmp.right);
            queue.offer(leftTmp.right);
            queue.offer(rightTmp.left);
        }

        return true;
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        boolean compare1 = compare(left.left, right.right);
        boolean compare2 = compare(left.right, right.left);

        return compare1 & compare2;
    }
}

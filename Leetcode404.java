public class Leetcode404 {
    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        int res = left + right;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        return res;
    }
}

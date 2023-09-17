public class Leetcode530 {
    public static void main(String[] args) {

    }

    public int result = Integer.MAX_VALUE;
    TreeNode pre ;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            traversal(root.left);
        }
        if (pre != null) {
            this.result = Math.min(Math.abs((root.val - pre.val)), this.result);
        }
        pre = root;
        if (root.right != null) {
            traversal(root.right);
        }
    }
}

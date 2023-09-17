public class Leetcode98 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}

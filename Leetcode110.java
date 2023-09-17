public class Leetcode110 {
    public static void main(String[] args) {

    }

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        getHeight(root);

        return result;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class Leetcode112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return getHeight(root, targetSum);
    }

    private boolean getHeight(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean tmp1 = false;
        boolean tmp2 = false;

        if (root.left != null) {
            targetSum -= root.val;
            tmp1 = getHeight(root.left, targetSum);
            targetSum += root.val;
        }

        if (root.right != null) {
            targetSum -= root.val;
            tmp2 = getHeight(root.right, targetSum);
            targetSum += root.val;
        }

        return tmp1 || tmp2;
    }
}

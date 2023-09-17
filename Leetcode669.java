public class Leetcode669 {
    public static void main(String[] args) {}

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val < low) {
            root = root.right;
        } else if (root.val > high) {
            root = root.left;
        }

        return root;
    }
}

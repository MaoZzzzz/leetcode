
public class Leetcode538 {
    public static void main(String[] args) {}

    private TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        return traversal(root);
    }

    private TreeNode traversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = (root.right != null) ? traversal(root.right) : null;
        root.val = (pre != null) ? root.val + pre.val : root.val;
        pre = root;
        root.left = (root.left != null) ? traversal(root.left) : null;

        return root;
    }
}
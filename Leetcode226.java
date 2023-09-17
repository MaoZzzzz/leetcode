public class Leetcode226 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        preorderTraversal(root);

        return root;
    }

    private void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}

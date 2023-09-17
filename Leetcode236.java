public class Leetcode236 {
    public static void main(String[] args) {}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode treeNodeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode treeNodeRight = lowestCommonAncestor(root.right, p, q);
        TreeNode result =
                (treeNodeLeft == null && treeNodeRight != null)
                        ? treeNodeRight
                        : (treeNodeLeft != null && treeNodeRight == null)
                                ? treeNodeLeft
                                : (treeNodeLeft != null && treeNodeRight != null) ? root : null;

        return result;
    }
}

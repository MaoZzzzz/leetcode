public class Leetcode235 {
    public static void main(String[] args) {}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return root = lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return root = lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

public class Leetcode700 {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        root = root.val > val ? root.left : root.right;
        return searchBST(root, val);
    }
}

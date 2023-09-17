public class Leetcode450 {
    public static void main(String[] args) {}

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }
}

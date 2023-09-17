public class Leetcode222 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        return digui(root);
    }

    private int digui(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftChild = 0;
        int rightChild = 0;

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        while (leftNode != null) {
            leftNode = leftNode.left;
            leftChild++;
        }

        while (rightNode != null) {
            rightNode = rightNode.right;
            rightChild++;
        }

        if (leftChild == rightChild) {
            return (2 << leftChild) - 1;
        }

        return digui(root.left) + digui(root.right) + 1;
    }

    private int baoli(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + baoli(root.left) + baoli(root.right);
    }
}

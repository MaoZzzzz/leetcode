public class Leetcode654 {
    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (right == left) {
            return new TreeNode(nums[left]);
        }

        int indexMaxNum = getIndexMaxNum(nums, left, right);
        System.out.printf("left: %d, right: %d \n", left, right);
        TreeNode root = new TreeNode(nums[indexMaxNum]);
        root.left = left <= indexMaxNum - 1 ? traversal(nums, left, indexMaxNum - 1) : null;
        root.right = right >= indexMaxNum + 1 ? traversal(nums, indexMaxNum + 1, right) : null;

        return root;
    }

    private int getIndexMaxNum(int[] nums, int left, int right) {
        int result = -1;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > result) {
                result = nums[i];
                index = i;
            }
        }

        return index;
    }
}

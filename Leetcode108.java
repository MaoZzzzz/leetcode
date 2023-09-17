public class Leetcode108 {
    public static void main(String[] args) {}

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = (mid - 1) >= left ? traversal(nums, left, mid - 1) : null;
        root.right = (mid + 1) <= right ? traversal(nums, mid + 1, right) : null;
        return root;
    }
}

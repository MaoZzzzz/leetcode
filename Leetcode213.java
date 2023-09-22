public class Leetcode213 {
    public static void main(String[] args) {
        Leetcode213 leetcode213 = new Leetcode213();
        int[] test = new int[] {1, 2, 3};
        System.out.println(leetcode213.rob(test));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robAction(nums, 0, nums.length - 2), robAction(nums, 1, nums.length - 1));
    }

    private int robAction(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}

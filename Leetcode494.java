import java.util.Arrays;

public class Leetcode494 {
    public static void main(String[] args) {}

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || (sum - target) % 2 == 1) {
            return 0;
        }

        int neg = (sum - target) / 2;

        int[] dp = new int[neg + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                System.out.println(dp[j - nums[i]] + dp[j]);
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + dp[j]);
            }
        }

        return dp[neg];
    }
}

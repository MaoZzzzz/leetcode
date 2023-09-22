public class Leetcode416 {
    public static void main(String[] args) {}

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        dp[nums[0]] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }
}

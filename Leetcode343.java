public class Leetcode343 {
    public static void main(String[] args) {}

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }

        return dp[n];
    }
}

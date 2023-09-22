public class Leetcode474 {
    public static void main(String[] args) {}

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int numZero = 0;
            int numOne = 0;
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                numZero = c == '0' ? numZero + 1 : numZero;
                numOne = c == '1' ? numOne + 1 : numOne;
            }

            for (int i = m; i >= numZero; i--) {
                for (int j = n; j >= numOne; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - numZero][j - numOne] + 1);
                }
            }
        }

        return dp[m][n];
    }
}

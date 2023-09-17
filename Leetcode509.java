public class Leetcode509 {
    public static void main(String[] args) {}

    public int fib(int n) {
        int[] dp = new int[31];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fibPress(int n) {
        int a = 0, b = 1, c = 0;
        if (n < 2) {
            return n;
        }
        for(int i = 2; i <= n; i++) {
            c =  a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

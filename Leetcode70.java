public class Leetcode70 {
    public static void main(String[] args) {}

    public int climbStairs(int n) {
        int a = 1, b = 2, c = 0;
        if (n <= 2) {
            return n;
        }
        for(int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

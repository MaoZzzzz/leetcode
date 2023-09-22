import java.util.Arrays;

public class Leetcode1363 {
    public static void main(String[] args) {
        Leetcode1363 leetcode1363 = new Leetcode1363();
        System.out.println(leetcode1363.largestMultipleOfThree(new int[] {3}));
    }

    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int[] cnt = new int[10];
        int[] mod = new int[3];
        int sum = 0;
        for (int i : digits) {
            cnt[i] += 1;
            mod[i % 3] += 1;
            sum++;
        }

        if (sum == 0) {

        }

        return "";
    }
}

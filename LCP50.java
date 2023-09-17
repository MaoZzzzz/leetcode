import java.util.Arrays;

public class LCP50 {
    public static void main(String[] args) {}

    public int giveGem(int[] gem, int[][] operations) {
        for (int i = 0; i < operations.length; i++) {
            gem[operations[i][1]] += gem[operations[i][0]] / 2;
            gem[operations[i][0]] -= gem[operations[i][0]] / 2;
        }

        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }
}

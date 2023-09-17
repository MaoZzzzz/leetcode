import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    public static void main(String[] args) {}

    private List<Integer> tmp = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return res;
    }

    private void backtracking(int k, int n, int startIndex, int sum) {
        if (tmp.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            tmp.add(i);
            sum += i;
            if (sum <= n) {
                backtracking(k, n, i + 1, sum);
            }
            sum -= i;
            tmp.remove(tmp.size() - 1);
        }
    }
}

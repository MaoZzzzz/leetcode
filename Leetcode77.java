import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    ArrayList<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {}

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return res;
    }

    private void backtracking(int startIndex, int n, int k) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            tmp.add(i);
            backtracking(i + 1, n, k);
            tmp.remove(tmp.size() - 1);
        }
    }
}

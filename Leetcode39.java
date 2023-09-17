import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {
    public static void main(String[] args) {}

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        // 剪枝操作
        for (int i = startIndex; i < candidates.length; i++) {
            if(sum + candidates[i] > target) break;
            tmp.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i, sum);
            sum -= candidates[i];
            tmp.remove(tmp.size() - 1);
        }
    }
}

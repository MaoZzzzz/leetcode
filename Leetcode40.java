import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    public static void main(String[] args) {
        Leetcode40 leetcode40 = new Leetcode40();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        leetcode40.combinationSum2(candidates, 8);
    }

    private List<Integer> tmp = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] flags = new boolean[candidates.length];
        Arrays.fill(flags, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, flags);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, boolean[] flags) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !flags[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }

            flags[i] = true;
            tmp.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1, flags);
            flags[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}

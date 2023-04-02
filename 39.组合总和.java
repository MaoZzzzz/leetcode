import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), 0, target, candidates);
        return res;
    }

    public void dfs(List<List<Integer>> res, ArrayList<Integer> tmp, int index, int target, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            tmp.add(candidates[i]);
            dfs(res, tmp, i, target - candidates[i], candidates);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end
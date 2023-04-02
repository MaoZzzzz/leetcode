import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] candidates, int target, int begin, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = begin + 1; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end


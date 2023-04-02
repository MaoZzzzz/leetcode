import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    String[] sss = { "(", ")" };

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();

        backtracking(res, stringBuilder, 0, 0, n);
        return res;
    }

    public void backtracking(List<String> res, StringBuilder stringBuilder, int open, int close, int n) {
        if (stringBuilder.length() == n * 2) {
            res.add(stringBuilder.toString());
            return;
        } 
        if (open < n) {
            stringBuilder.append("(");
            backtracking(res, stringBuilder, open + 1, close, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < open) {
            stringBuilder.append(")");
            backtracking(res, stringBuilder, open, close + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
// @lc code=end

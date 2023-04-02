
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3166 👎 0

package Temp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:括号生成
class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> res = new ArrayList<String>();
            backTracking(res, new StringBuilder(), n, 0, 0);
            return res;
        }

        public void backTracking(List<String> res, StringBuilder stringBuilder, int n, int leftNums, int rightNums) {
            if (stringBuilder.length() == n * 2) {
                res.add(stringBuilder.toString());
                return;
            }

            if (leftNums < n) {
                stringBuilder.append("(");
                backTracking(res, stringBuilder, n, leftNums + 1, rightNums);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }

            if (rightNums < leftNums) {
                stringBuilder.append(")");
                backTracking(res, stringBuilder, n, leftNums, rightNums + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
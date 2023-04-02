import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return new ArrayList<String>();
        List<String> combinations = new ArrayList<String>();
        // combinations.add(combinations)
        backtracking(combinations, new StringBuilder(), digits, 0);
        return combinations;
    }

    public void backtracking(List<String> combinations, StringBuilder stringBuilder, String digits, int index) {
        if (index == digits.length()) {
            combinations.add(stringBuilder.toString());
        } else {
            char digit = digits.charAt(index);
            String hashRes = phoneMap.get(digit);
            int length = hashRes.length();
            for (int j = 0; j < length; j++) {
                stringBuilder.append(hashRes.charAt(j));
                backtracking(combinations, stringBuilder, digits, index + 1);
                stringBuilder.deleteCharAt(index);
            }
        }

    }
}
// @lc code=end


class Solution2 {
    HashMap<String, String> map = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>() {};
        }
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), digits, 0);
        return res;
    }

    public void backTrack(List<String> res, StringBuilder stringBuilder, String digits, int index) {
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        } else {
            char digit = digits.charAt(index);
            String hashRes = map.get(String.valueOf(digit));
            int length = hashRes.length();
            for (int i = 0; i < length; i++) {
                char c = hashRes.charAt(i);
                stringBuilder.append(c);
                backTrack(res, stringBuilder, digits, index + 1);
                stringBuilder.deleteCharAt(index);
            }
        }

        
    }
}
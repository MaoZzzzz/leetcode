import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */


class SolutionHashMap {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            // 要做的就是移动窗口位置
            // 如果当前的 map 中包括了全部的当前出现的字符，那么要做的就是移动窗口的位置，因为当前窗口中一定有重复元素
            // 移动窗口需要考虑特殊情况，abca 这种是最普遍的情况，只需要将 left = map.get('a')
            // 如果是 abba 这种情况，那么当第二个 a 出现时
            // 窗口大小是 b ，但是此时 left 应该是不变的，但是由于 a 的进入导致了 left 出现错误，left 应该是当前值
            if (map.containsKey(s.charAt(i))) left = Math.max(left, map.get(s.charAt(i)) + 1);

            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
        
    }
}


// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int windowSize = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (right != s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                windowSize += 1;
                res = Math.max(res, windowSize);
            } else {
                set.remove(s.charAt(left));
                left++;
                windowSize -= 1;   
            }
        }
        return res;
    }
}
// @lc code=end
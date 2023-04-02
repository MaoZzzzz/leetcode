/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */


class SolutionDynamic {
    public String longestPalindrome(String s) {
        int length = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++)
            dp[i][i] = true;
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length; i++) {
                int j = i + l - 1;
                if (j >= length)
                    break;

                if (s.charAt(i) == s.charAt(j))
                    if (l == 2)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = false;

                if (dp[i][j] == true && l > maxLen) {
                    maxLen = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}


// @lc code=start
class Solution {
    /**
     * 去中心化
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLength(s, i, i);
            int len2 = getLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1){
                // 注意这里的 start 和 end 取值
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int getLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// @lc code=end
import java.util.List;

public class Leetcode139 {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int len = wordDict.get(j).length();
                if (i - len >= 0 && wordDict.contains(s.substring(i - len, i + 1)) && dp[i - len]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

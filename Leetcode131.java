import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    public static void main(String[] args) {
        Leetcode131 leetcode131 = new Leetcode131();
        leetcode131.partition("aab");
    }

    private List<List<String>> res = new ArrayList<>();
    private ArrayList<String> tmp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (check(s, startIndex, i)) {
                tmp.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    private boolean check(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

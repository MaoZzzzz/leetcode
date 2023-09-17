import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    public static void main(String[] args) {
        Leetcode93 leetcode93 = new Leetcode93();
        List<String> strings = leetcode93.restoreIpAddresses("010010");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        backtracking(s, 0);
        return res;
    }

    private List<String> tmp = new ArrayList<>();
    private List<String> res = new ArrayList<>();

    private void backtracking(String s, int startIndex) {
        if (tmp.size() == 3) {
            if (check(s, startIndex, s.length() - 1)) {
                tmp.add(s.substring(startIndex, s.length()));
            } else {
                return;
            }
            StringBuilder sb = new StringBuilder();
            tmp.forEach(
                    item -> {
                        sb.append(item);
                        sb.append(".");
                    });
            sb.delete(sb.length() - 1, sb.length());
            res.add(sb.toString());
            tmp.remove(tmp.size() - 1);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (check(s, startIndex, i)) {
                tmp.add(s.substring(startIndex, i + 1));
                backtracking(s, i + 1);
                tmp.remove(tmp.size() - 1);
            } else {
                break;
            }
        }
    }

    private boolean check(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int j = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) - '0' > 9) {
                return false;
            }
            j = j * 10 + (s.charAt(i) - '0');
            if (j > 255) {
                return false;
            }
        }
        return true;
    }
}

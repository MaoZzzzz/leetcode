import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        // String res = "";
        ArrayList<Character> tmp = new ArrayList<>();

        int index = 0;
        while (true) {
            if (strs[0].length() != 0 && strs[0].charAt(index) != 0) {
                tmp.add(strs[0].charAt(index));
            } else {
                return "";
            }
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() >= index) {
                    continue;
                }
                // if (strs[0].length() != 0 && strs[i].charAt(index) != 0 && strs[i].charAt(index) == tmp.get(index)) {
                //     continue;
                // }
                return strs[0].substring(0, index - 1);
            }
            index++;
        }
    }
}

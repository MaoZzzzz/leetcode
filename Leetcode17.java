import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {
    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        List<String> strings = leetcode17.letterCombinations("23");

        strings.forEach(System.out::println);
    }

    private String[] numsString =
            new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> res = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        int[] tmp = new int[digits.length()];
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            tmp[i] = Character.getNumericValue(chars[i]);
        }

        backtracking(tmp);
        return digits.isEmpty() ? new ArrayList<>() : res;
    }

    private void backtracking(int[] digits) {
        if (stringBuilder.length() == digits.length) {
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < numsString[digits[stringBuilder.length()]].length(); i++) {
            stringBuilder.append(numsString[digits[stringBuilder.length()]].charAt(i));
            backtracking(digits);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

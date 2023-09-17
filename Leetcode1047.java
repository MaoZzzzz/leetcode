import java.util.ArrayDeque;

public class Leetcode1047 {
    public static void main(String[] args) {
        String test = "abbaca";

        System.out.println(removeDuplicates(test));
    }

    public static String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else if (stack.isEmpty()) {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() != c) {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}

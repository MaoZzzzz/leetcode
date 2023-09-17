import java.util.Stack;

public class Leetcode20 {
    public static void main(String[] args) {
        String test = "(}";

        System.out.println(isValid(test));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                case '[':
                case '{':
                    stack.push(aChar);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
            }
        }

        return stack.isEmpty();
    }
}

import java.util.Stack;

public class Leetcode150 {

    public static void main(String[] args) {
        String[] test = new String[]{"2", "1", "+", "3", "*"};

        System.out.println(evalRPN(test));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                nums.push(nums.pop() + nums.pop());
            } else if (s.equals("-")) {
                nums.push(-nums.pop() + nums.pop());
            } else if (s.equals("*")) {
                nums.push(nums.pop() * nums.pop());
            } else if (s.equals("/")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2 / num1);
            } else {
                nums.push(Integer.valueOf(s));
            }
        }

        return nums.pop();
    }
}

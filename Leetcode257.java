import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        traversal(root, tmp, result);

        return result;
    }

    private void traversal(TreeNode root, List<Integer> tmp, List<String> result) {
        if (root.left == null && root.right == null) {
            tmp.add(root.val);
            StringBuilder sb = new StringBuilder();
            for (int i : tmp) {
                sb.append(i).append("->");
            }
            sb.delete(sb.length() - 2, sb.length());
            result.add(sb.toString());
            tmp.remove(tmp.size() - 1);
            return;
        }

        if (root.left != null) {
            tmp.add(root.val);
            traversal(root.left, tmp, result);
            tmp.remove(tmp.size() - 1);
        }

        if (root.right != null) {
            tmp.add(root.val);
            traversal(root.right, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}

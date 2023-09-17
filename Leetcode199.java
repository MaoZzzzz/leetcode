import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode treeNodeTmp = queue.poll();

                if (treeNodeTmp.left != null) {
                    queue.offer(treeNodeTmp.left);
                }

                if (treeNodeTmp.right != null) {
                    queue.offer(treeNodeTmp.right);
                }

                if (len == 1) {
                    result.add(treeNodeTmp.val);
                }
                len--;
            }
        }

        return result;
    }
}

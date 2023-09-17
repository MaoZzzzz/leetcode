import java.util.ArrayList;
import java.util.List;

public class Leetcode501 {
    public static void main(String[] args) {

    }

    private List<Integer> resList = new ArrayList<>();
    private int maxCount = 0;
    private int count = 0;
    private TreeNode pre = new TreeNode(0);

    public int[] findMode(TreeNode root) {
        traversal(root);

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            traversal(root.left);
        }

        if (pre != null) {
            count = pre.val == root.val ? count + 1 : 1;
            if (count > maxCount) {
                maxCount = count;
                resList.clear();
                resList.add(root.val);
            } else if (count == maxCount) {
                resList.add(root.val);
            }
        }

        pre = root;
        if (root.right != null) {
            traversal(root.right);
        }
    }
}

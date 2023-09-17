import java.util.ArrayList;
import java.util.List;

public class Leetcode797 {
    public static void main(String[] args) {}

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return result;
    }

    private void dfs(int[][] graph, int start) {
        if (start == graph.length - 1) {
            tmp.add(start);
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }

        for (int i = 0; i < graph[start].length; i++) {
            tmp.add(start);
            dfs(graph, graph[start][i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Leetcode417 {
    public static void main(String[] args) {}

    private int[][] dir = {
        {0, 1},
        {1, 0},
        {-1, 0},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] flagsPacific = new boolean[heights.length][heights[0].length];
        boolean[][] flagsAtlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, flagsPacific, i, 0);
            dfs(heights, flagsAtlantic, i, heights[0].length - 1);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, flagsPacific, 0, i);
            dfs(heights, flagsAtlantic, heights.length - 1, i);
        }

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if (flagsPacific[i][j] && flagsAtlantic[i][j]) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] flags, int x, int y) {
        if (flags[x][y]) {
            return;
        }
        flags[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextX >= heights.length || nextY < 0 || nextY >= heights[0].length) {
                continue;
            }
            if (heights[x][y] > heights[nextX][nextY]) {
                continue;
            }
            dfs(heights, flags, nextX, nextY);
        }
    }
}

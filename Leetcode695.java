import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode695 {
    public static void main(String[] args) {}

    private boolean[][] flags;
    private int result;
    private int tmp;
    private int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        result = 0;
        flags = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!flags[i][j] && grid[i][j] == 1) {
                    tmp = 0;
                    dfs(grid, i, j);
                    result = Math.max(result, tmp);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (flags[x][y] || grid[x][y] == 0) {
            return;
        }
        flags[x][y] = true;
        tmp++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                continue;
            }
            dfs(grid, nextX, nextY);
        }
    }

    private void bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        flags[x][y] = true;
        tmp++;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dir[i][0];
                int nextY = cur[1] + dir[i][1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }
                if (!flags[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.offer(new int[] {nextX, nextY});
                    flags[nextX][nextY] = true;
                    tmp++;
                }
            }
        }
    }
}

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode200 {
    public static void main(String[] args) {}

    private int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private boolean[][] flags;

    public int numIslands(char[][] grid) {
        int count = 0;
        flags = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!flags[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (flags[x][y] || grid[x][y] == '0') {
            return;
        }

        flags[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0
                    || nextX >= grid.length
                    || nextY < 0
                    || nextY >= grid[0].length
                    || flags[nextX][nextY]) {
                continue;
            }
            dfs(grid, nextX, nextY);
        }
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        flags[x][y] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[0] + dir[i][0];
                int nextY = tmp[1] + dir[i][1];
                if (nextX < 0
                        || nextX >= grid.length
                        || nextY < 0
                        || nextY >= grid[0].length
                        || flags[nextX][nextY]
                        || grid[nextX][nextY] == '0') {
                    continue;
                }
                queue.offer(new int[] {nextX, nextY});
                flags[nextX][nextY] = true;
            }
        }
    }
}

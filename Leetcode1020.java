public class Leetcode1020 {
    public static void main(String[] args) {}

    private int result = 0;
    private int[][] dir = {
        {0, 1},
        {1, 0},
        {-1, 0},
        {0, -1}
    };

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(grid, i, grid[0].length - 1);
            }
        }
        for (int j = 1; j < grid[0].length; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[grid.length - 1][j] == 1) {
                dfs(grid, grid.length - 1, j);
            }
        }

        result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;
        result++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                continue;
            }
            dfs(grid, nextX, nextY);
        }
    }
}

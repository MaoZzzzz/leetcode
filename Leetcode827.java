import java.util.HashMap;
import java.util.HashSet;

public class Leetcode827 {
    public static void main(String[] args) {}

    private HashMap<Integer, Integer> area = new HashMap<>();
    private int tmp;
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int index = 1;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    tmp = 0;
                    dfs(grid, i, j, ++index);
                    area.put(index, tmp);
                    result = Math.max(tmp, result);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i != 0 ? grid[i - 1][j] : 0);
                    set.add(i != grid.length - 1 ? grid[i + 1][j] : 0);
                    set.add(j != grid.length - 1 ? grid[i][j + 1] : 0);
                    set.add(j != 0 ? grid[i][j - 1] : 0);

                    int sum = 0;
                    for (Integer k : set) {
                        sum += area.getOrDefault(k, 0);
                    }

                    result = Math.max(sum + 1, result);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int x, int y, int index) {
        if (grid[x][y] != 1) {
            return;
        }
        grid[x][y] = index;
        tmp++;
        for (int i = 0; i < 4; i++) {
            int curRow = x + position[i][0], curCol = y + position[i][1];
            if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid.length) {
                continue;
            }
            dfs(grid, curRow, curCol, index);
        }
    }
}

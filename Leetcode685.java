public class Leetcode685 {
    public static void main(String[] args) {
        Leetcode685 leetcode685 = new Leetcode685();
        int[][] test = {
            {1, 2},
            {1, 3},
            {2, 3}
        };
        leetcode685.findRedundantDirectedConnection(test);
    }

    private int n;

    private int[] parent;

    public Leetcode685() {
        this.n = 1001;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    private boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        parent[v] = u;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        for (int[] edge : edges) {
            for (int j = 0; j < edges.length + 1; j++) {
                System.out.print(parent[j] + " ");
            }
            if (isSame(edge[0], edge[1])) {
                return edge;
            } else {
                join(edge[0], edge[1]);
            }
        }
        return null;
    }
}

public class Leetcode684 {
    public static void main(String[] args) {}

    private int n;
    private int[] parent;

    private void init(int n) {
        this.n = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        parent[v] = u;
    }

    private boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    private int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                return edges[i];
            }
            join(edges[i][0], edges[i][1]);
        }
        return null;
    }
}

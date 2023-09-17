public class Leetcode1971 {
    public static void main(String[] args) {}

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            unionFind.join(edges[i][0], edges[i][1]);
        }

        return unionFind.isSame(source, destination);
    }
}

class UnionFind {
    private int n;
    private int[] parent;

    public UnionFind(int n) {
        this.n = n;
        this.parent = new int[n];
        init();
    }

    public void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int u) {
        if (u == parent[u]) {
            return u;
        } else {
            parent[u] = find(parent[u]);
            return parent[u];
        }
    }

    public boolean isSame(int u, int v) {
        for(int i = 0; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
        u = find(u);
        v = find(v);
        return u == v;
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        parent[v] = u;
    }
}

class Solution {

    List<Integer>[] g;
    int T, target;
    public double frogPosition(int n, int[][] edges, int t, int target) {
         g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        this.T = t;
        this.target = target;
        return dfs(1, 0, 0, 1.0);
    }

    private double dfs(int u, int parent, int time, double prob) {
        if (time == T) return (u == target) ? prob : 0.0;

        int choices = g[u].size() - (parent == 0 ? 0 : 1);

        if (u == target) {
            // Arrived early: must stay only if no outgoing choices
            return (choices == 0) ? prob : 0.0;
        }

        if (choices == 0) return 0.0;

        double share = prob / choices, ans = 0.0;
        for (int v : g[u]) {
            if (v == parent) continue;
            ans += dfs(v, u, time + 1, share);
        }
        return ans;
    }
}

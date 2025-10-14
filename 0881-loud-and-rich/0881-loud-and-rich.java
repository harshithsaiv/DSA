import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        // Build reverse graph: poorer -> richer
        List<List<Integer>> rev = new ArrayList<>(n);
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());
        for (int[] e : richer) rev.get(e[1]).add(e[0]);

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) dfs(i, rev, quiet, ans);
        return ans;
    }

    private int dfs(int u, List<List<Integer>> rev, int[] quiet, int[] ans) {
        if (ans[u] != -1) return ans[u];
        int best = u; // candidate: self
        for (int r : rev.get(u)) {
            int cand = dfs(r, rev, quiet, ans); // quietest among richer nodes
            if (quiet[cand] < quiet[best]) best = cand;
        }
        ans[u] = best;
        return best;
    }
}

import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1_000_000_000; // large sentinel to avoid overflow
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {         // at most k stops => at most k+1 edges
            int[] next = dist.clone();         // read-only snapshot for this round
            boolean changed = false;
            for (int[] e : flights) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] != INF && dist[u] + w < next[v]) {
                    next[v] = dist[u] + w;
                    changed = true;
                }
            }
            dist = next;
            if (!changed) break;               // optional early exit
        }
        return dist[dst] >= INF ? -1 : dist[dst];
    }
}

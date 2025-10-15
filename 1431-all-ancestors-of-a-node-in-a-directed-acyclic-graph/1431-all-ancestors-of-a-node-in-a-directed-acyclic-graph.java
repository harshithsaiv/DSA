import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] indeg = new int[n];
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            indeg[e[1]]++;
        }

        BitSet[] anc = new BitSet[n];
        for (int i = 0; i < n; i++) anc[i] = new BitSet(n);

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                anc[v].or(anc[u]);  
                anc[v].set(u);      
                if (--indeg[v] == 0) q.offer(v);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int b = anc[i].nextSetBit(0); b >= 0; b = anc[i].nextSetBit(b + 1)) {
                list.add(b);
            }
            ans.add(list);
        }
        return ans;
    }
}

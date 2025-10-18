import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 1ï¸â£ Assign unique groups for items with group == -1
        int nextG = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = nextG++;
        }
        int G = nextG; // total groups

        // 2ï¸â£ Build adjacency lists
        List<Integer>[] gAdj = new ArrayList[G];
        List<Integer>[] itemAdj = new ArrayList[n];
        for (int i = 0; i < G; i++) gAdj[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) itemAdj[i] = new ArrayList<>();

        int[] gIndeg = new int[G];
        int[] itemIndeg = new int[n];

        List<Integer>[] itemsInGroup = new ArrayList[G];
        for (int i = 0; i < G; i++) itemsInGroup[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) itemsInGroup[group[i]].add(i);

        // 3ï¸â£ Build graphs
        for (int v = 0; v < n; v++) {
            for (int u : beforeItems.get(v)) {
                if (group[u] != group[v]) {
                    gAdj[group[u]].add(group[v]);
                    gIndeg[group[v]]++;
                } else {
                    itemAdj[u].add(v);
                    itemIndeg[v]++;
                }
            }
        }

        // 4ï¸â£ Topo sort groups
        List<Integer> groupOrder = topoOrder(G, gAdj, gIndeg);
        if (groupOrder.isEmpty()) return new int[0];

        // 5ï¸â£ For each group in order, topo sort its items
        List<Integer> ans = new ArrayList<>();
        for (int g : groupOrder) {
            List<Integer> nodes = itemsInGroup[g];
            if (nodes.isEmpty()) continue;

            int[] localIndeg = new int[n];
            for (int v : nodes) localIndeg[v] = itemIndeg[v];

            Deque<Integer> dq = new ArrayDeque<>();
            for (int v : nodes) if (localIndeg[v] == 0) dq.add(v);

            List<Integer> block = new ArrayList<>();
            while (!dq.isEmpty()) {
                int x = dq.poll();
                block.add(x);
                for (int y : itemAdj[x]) {
                    localIndeg[y]--;
                    if (localIndeg[y] == 0) dq.add(y);
                }
            }
            if (block.size() != nodes.size()) return new int[0];
            ans.addAll(block);
        }

        // 6ï¸â£ Convert List<Integer> â int[]
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    // Standard Kahn's Topo Sort
    private List<Integer> topoOrder(int n, List<Integer>[] adj, int[] indeg) {
        int[] indegCopy = Arrays.copyOf(indeg, indeg.length);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indegCopy[i] == 0) dq.add(i);

        List<Integer> out = new ArrayList<>();
        while (!dq.isEmpty()) {
            int x = dq.poll();
            out.add(x);
            for (int y : adj[x]) {
                indegCopy[y]--;
                if (indegCopy[y] == 0) dq.add(y);
            }
        }
        return (out.size() == n) ? out : Collections.emptyList();
    }
}
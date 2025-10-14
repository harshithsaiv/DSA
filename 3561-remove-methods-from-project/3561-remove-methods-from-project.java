class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //Creating a graph
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int [] e: invocations) g.get(e[0]).add(e[1]);

        // All the nodes reachable from k
        boolean[] suspicious = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(k);
        suspicious[k] =true;
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : g.get(u)) {
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    dq.offer(v);
                }
            }
        }

        boolean blocked = false;
        for (int[] e : invocations) {
            int u = e[0], v = e[1];
            if (suspicious[v] && !suspicious[u]) {
                blocked = true; 
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (blocked) {
            for (int i = 0; i < n; i++) ans.add(i);
        } else {
            for (int i = 0; i < n; i++) if (!suspicious[i]) ans.add(i);
        }
        return ans;
    }
}
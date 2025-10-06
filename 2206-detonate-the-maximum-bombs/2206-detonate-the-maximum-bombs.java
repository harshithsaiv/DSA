class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build graph: check if bomb i can detonate bomb j
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x2 = bombs[j][0], y2 = bombs[j][1];

                long dx = x2 - x1;
                long dy = y2 - y1;
                long distSq = dx * dx + dy * dy;

                // Use r1 * r1 to avoid floating point error from sqrt
                if (distSq <= r1 * r1) {
                    adjList.get(i).add(j);
                }
            }
        }

        // DFS to find max bombs detonated starting from each bomb
        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = dfs(i, adjList, visited);
            maxDetonated = Math.max(maxDetonated, count);
        }

        return maxDetonated;
    }

    private int dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        int count = 1;  // Count current bomb
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, adjList, visited);
            }
        }
        return count;
    }
}

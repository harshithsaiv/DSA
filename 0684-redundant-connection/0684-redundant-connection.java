class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        graph = new ArrayList[n + 1]; // Use n+1 to handle 1-based indexing
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // Reset visited array for each DFS check
            visited = new boolean[n + 1];
            
            // Check if adding this edge forms a cycle
            if (hasPath(u, v, -1)) {
                return edge;
            }
            
            // If no cycle, add the edge to the graph
            graph[u].add(v);
            graph[v].add(u);
        }
        return new int[]{};
    }

    private boolean hasPath(int current, int target, int parent) {
        if (current == target) {
            return true;
        }
        visited[current] = true;
        for (int neighbor : graph[current]) {
            if (neighbor != parent && !visited[neighbor]) {
                if (hasPath(neighbor, target, current)) {
                    return true;
                }
            }
        }
        return false;
    }
}
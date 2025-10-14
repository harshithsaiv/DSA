class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];

        // Step 1: Count indegrees
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                if (indegree[leftChild[i]] > 1) return false;
            }
            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                if (indegree[rightChild[i]] > 1) return false;
            }
        }

        // Step 2: Find root (node with indegree 0)
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) return false;  // More than one root
                root = i;
            }
        }

        if (root == -1) return false; // No root found

        // Step 3: DFS to check for connectivity and cycles
        boolean[] visited = new boolean[n];
        if (!dfs(root, visited, leftChild, rightChild)) return false;

        // Step 4: Ensure all nodes were visited
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private boolean dfs(int node, boolean[] visited, int[] leftChild, int[] rightChild) {
        if (visited[node]) return false; // Cycle detected
        visited[node] = true;

        if (leftChild[node] != -1) {
            if (!dfs(leftChild[node], visited, leftChild, rightChild)) return false;
        }
        if (rightChild[node] != -1) {
            if (!dfs(rightChild[node], visited, leftChild, rightChild)) return false;
        }
        return true;
    }
}

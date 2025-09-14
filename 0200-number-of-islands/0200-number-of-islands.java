import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(m * n);

        // 1) Initialize: mark land parents and count how many lands we have
        int landCount = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int id = r * n + c;
                if (grid[r][c] == '1') {
                    uf.parent[id] = id; // land: self parent
                    landCount++;
                } else {
                    uf.parent[id] = -1; // water sentinel
                }
            }
        }
        uf.count = landCount; // start with each land cell as its own island

        // 2) Union adjacent lands (check right and down to avoid duplicates)
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != '1') continue;
                int id = r * n + c;
                if (r + 1 < m && grid[r + 1][c] == '1') uf.union(id, (r + 1) * n + c);     // down
                if (c + 1 < n && grid[r][c + 1] == '1') uf.union(id, r * n + (c + 1));     // right
            }
        }

        return uf.count; // remaining disjoint land sets = number of islands
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count; // number of disjoint land sets

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(parent, -1); // default water
        }

        int find(int x) {
            if (x < 0 || parent[x] == -1) return -1; // water or invalid
            if (parent[x] != x) parent[x] = find(parent[x]); // path compression
            return parent[x];
        }

        void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == -1 || rb == -1 || ra == rb) return; // ignore water or same set

            // union by rank
            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
            count--; // two islands merged into one
        }
    }
}

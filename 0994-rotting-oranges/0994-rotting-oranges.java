class Solution {
    public int orangesRotting(int[][] grid) {
        
        Set<String> rotten = new HashSet<>();
        Set<String> fresh = new HashSet<>();
        
        // Initialize sets for rotten and fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2)
                    rotten.add(i + "," + j);
                if (grid[i][j] == 1)
                    fresh.add(i + "," + j);
            }
        }
        
        int min = 0;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // Process while there are fresh oranges left
        while (fresh.size() > 0) {
            Set<String> spoilt = new HashSet<>();
            for (String s : rotten) {
                int i = Integer.parseInt(s.split(",")[0]);
                int j = Integer.parseInt(s.split(",")[1]);
                
                // Check all four directions
                for (int[] directions : dir) {
                    int nextI = i + directions[0];
                    int nextJ = j + directions[1];
                    String nextPos = nextI + "," + nextJ;
                    
                    // Check if the neighboring cell is fresh and within bounds
                    if (fresh.contains(nextPos)) {
                        fresh.remove(nextPos);
                        spoilt.add(nextPos);
                    }
                }
            }
            
            // If no new oranges turned rotten, return -1
            if (spoilt.size() == 0) return -1;
            
            rotten = spoilt; // Update rotten oranges set with newly rotten ones
            min++;
        }
        return min;
    }
}

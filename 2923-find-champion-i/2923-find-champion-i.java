class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;

        Map<Integer, Integer> rowCount = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount.put(i, rowCount.getOrDefault(i, 0) + 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> elem : rowCount.entrySet()) {
            int winner = elem.getKey();
            int val = elem.getValue(); 
            if (val == n - 1) { 
                return winner; 
            }
        }

        return -1; 
    }
}

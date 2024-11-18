class Solution {
    public int numSpecial(int[][] mat) {
         int m = mat.length;
        int n = mat[0].length;

        // HashMaps to store counts of 1's in each row and column
        HashMap<Integer, Integer> rowCount = new HashMap<>();
        HashMap<Integer, Integer> colCount = new HashMap<>();

        // Populate the HashMaps with the counts of 1's in rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount.put(i, rowCount.getOrDefault(i, 0) + 1);
                    colCount.put(j, colCount.getOrDefault(j, 0) + 1);
                }
            }
        }

        int specialCount = 0;

        // Check for special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount.get(i) == 1 && colCount.get(j) == 1) {
                    specialCount++;
                }
            }
        }

        return specialCount;
    }
    
}
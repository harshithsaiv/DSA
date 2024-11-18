class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
        List<Integer> res = new ArrayList<>();
        
        int[] rowMin = new int[m]; // To store the minimum value of each row
        int[] colMax = new int[n]; // To store the maximum value of each column
        
        // Find the minimum value of each row
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            rowMin[i] = min;
        }
        
        // Find the maximum value of each column
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] > max) {
                    max = matrix[j][i];
                }
            }
            colMax[i] = max;
        }
        
        // Find the lucky numbers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        
        return res;
    }
}

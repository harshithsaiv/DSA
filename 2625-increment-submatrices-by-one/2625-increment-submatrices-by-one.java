class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][] matrix = new int[n][n];

        for(int []query : queries){
            int start_row = query[0];
            int start_col = query[1];
            int end_row = query[2];
            int end_col = query[3];
            for(int i=start_row;i<=end_row;i++){
                for(int j=start_col;j<=end_col;j++){
                    matrix[i][j] = matrix[i][j]+ 1;
                }
            }
        }
        return matrix;
    }
}
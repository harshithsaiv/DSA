class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        
        int m= matrix.length;
        int n= matrix[0].length;
        
        int deepCopy[][]= new int[m][n];

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
               deepCopy[i][j] = matrix[i][j];
            }
        }
        
        int colmax[] = new int [n];
        for(int i=0;i<n;i++){
            int max = -9999;
            for(int j=0;j<m;j++){
                max = Math.max(max,matrix[j][i]);
            }
            colmax[i]=max;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(deepCopy[i][j]==-1){
                    deepCopy[i][j]=colmax[j];
                }
            }
        }
        return deepCopy;
    }
}
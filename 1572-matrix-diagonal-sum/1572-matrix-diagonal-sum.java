class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int n= mat.length;
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i];
            mat[i][i]=-99;
        }
        for(int i=0,j=mat.length-1;i<mat.length && j>=0;i++,j--){
            if(mat[i][j]!=-99)
                sum+=mat[i][j];
        }
        return sum;
    }
}
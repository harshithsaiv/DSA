class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        Queue<Integer> numbers = new LinkedList<>();
        
        int [][] res = new int [r][c];
        
        for (int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                numbers.add(mat[i][j]);
            }
        }
        if(numbers.size() == r*c){
            for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res[i][j] = numbers.remove();
            }
        }
        return res;
        }
        else
            return mat;
        
    }
}
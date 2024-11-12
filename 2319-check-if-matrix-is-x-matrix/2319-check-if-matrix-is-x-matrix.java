class Solution {
    public boolean checkXMatrix(int[][] grid) {
        return (checkDiagonal(grid) && checkzero(grid));
    }
    
    public boolean checkDiagonal(int[][] grid){
        int n = grid.length;
        
        for(int i=0;i<n;i++){
            if(grid[i][i]==0)
                return false;
        }
        
        for(int i=0,j=n-1;i<n && j>=0;i++,j--){
            if(grid[i][j]==0)
                return false;
            else
                grid[i][j]=0;
        }
       
        for(int i=0;i<n;i++){
            grid[i][i]=0;
        }
         return true;
    }
    
    public boolean checkzero(int [][]grid){
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }
}
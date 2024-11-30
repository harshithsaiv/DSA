class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res[] = new int[n];        
        
        for(int j=0;j<n;j++){
            int max=0;
            for(int i=0;i<m;i++){
                int elem = grid[i][j];
                String s = Integer.toString(elem);
                max=Math.max(max,s.length());
            }
            res[j]=max;
        }
        return res;
    }
}
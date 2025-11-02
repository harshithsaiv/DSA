class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int result [][] =  new int[m][n];
        for(int []wall :walls){
            int row = wall[0];
            int col = wall[1];
            result[row][col]=2;
        }
        
        for(int []guard : guards){
            int row = guard[0];
            int col = guard[1];
            result[row][col]=1;
        }
        // Make all the cells from 1 to nearest 2 as 3 and then calculate the no of zeros
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int[] g : guards) {
            int r = g[0], c = g[1];
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                while (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    // stop if wall or guard
                    if (result[nr][nc] == 2 || result[nr][nc] == 1) break;
                    // mark as seen
                    if (result[nr][nc] == 0) {
                        result[nr][nc] = 3;
                    }
                    nr += d[0];
                    nc += d[1];
                }
            }
        }


        int count =0;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(result[i][j]==0)
                    count++;
            }
        }
        return count;
    }
}
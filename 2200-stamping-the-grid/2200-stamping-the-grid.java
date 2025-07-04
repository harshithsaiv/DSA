class Solution {
        public boolean possibleToStamp(int[][] M, int h, int w) {
        int m = M.length, n = M[0].length;
        int[][] A = new int[m + 1][n + 1], B = new int[m + 1][n + 1], good = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i + 1][j + 1] = A[i + 1][j] + A[i][j + 1] - A[i][j] + (1 - M[i][j]);
                if (i + 1 >= h && j + 1 >= w) {   
                    int x = i + 1 - h, y = j + 1 - w;
                    if (A[i + 1][j + 1] - A[x][j + 1] - A[i + 1][y] + A[x][y] == w * h)
                        good[i][j]++;
                }
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                B[i + 1][j + 1] = B[i + 1][j] + B[i][j + 1] - B[i][j] + good[i][j];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = Math.min(i + h, m), y = Math.min(j + w, n);
                if (M[i][j] == 0 && B[x][y] - B[i][y] - B[x][j] + B[i][j] == 0)
                    return false;
            }
        }
        return true; 
    }
}
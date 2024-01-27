//Approach 1 (Using recursion)
// class Solution {
//     public int count =0;
//     public  int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//         out(startRow-1,startColumn,n,m,maxMove-1);
//         // System.out.println(count);
//         out(startRow+1,startColumn,n,m,maxMove-1);
//         // System.out.println(count);
//         out(startRow,startColumn+1,n,m,maxMove-1);
//         // System.out.println(count);
//         out(startRow,startColumn-1,n,m,maxMove-1);
//         // System.out.println(count);
//         return count;
//     }
//     public void out(int row,int column,int n,int m, int maxMove)
//     {
//         // System.out.println("Row:"+row+"Column: "+column+" MaxMoves:"+maxMove);
//         if(maxMove>=0)
//         {
//             if(row<0 || row>m || row==m)
//             {
//                 count++;
//             }
//             else if(column<0 || column>n || column==n)
//             {
//                 count++;
//             }
//             else
//             {
//                 findPaths(m,n,maxMove,row,column);
//             }
//         }
//     }
// }

//Approach 2  using memoization
class Solution {
    Integer dp[][][];
    int M = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove + 1];
        return solve(m, n, maxMove, startRow, startColumn);
    }

    public int solve(int m, int n, int moves, int row, int col) {
        if (row >= m || col >= n || row < 0 || col < 0) {
            return 1;
        }
        if (moves <= 0) {
            return 0;
        }
        if (dp[row][col][moves] != null) {
            return dp[row][col][moves];
        }
        int ans = 0;
        ans = (ans + solve(m, n, moves - 1, row - 1, col)) % M;
        ans = (ans + solve(m, n, moves - 1, row + 1, col)) % M;
        ans = (ans + solve(m, n, moves - 1, row, col - 1)) % M;
        ans = (ans + solve(m, n, moves - 1, row, col + 1)) % M;
        return dp[row][col][moves] = ans;
    }
}

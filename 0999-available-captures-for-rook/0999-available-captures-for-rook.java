class Solution {
    public int numRookCaptures(char[][] board) {
        int n = board.length;
        int row=0;
        int col=0;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='R'){
                    row =i;
                    col =j;
                }    
            }
        }
        //Moving right
        for(int ptr=col+1;ptr<n;ptr++){
            if(board[row][ptr]=='B'){
                break;
            }
            else if(board[row][ptr]=='p'){
                count++;
                break;
            }
        }
           
        //Moving left
            for(int ptr=col-1;ptr>=0;ptr--){
            if(board[row][ptr]=='B'){
                break;
            }
            else if(board[row][ptr]=='p'){
                count++;
                break;
            }
            }
                
         // Moving up
            for(int ptr=row-1;ptr>=0;ptr--){
            if(board[ptr][col]=='B'){
                break;
            }
            else if(board[ptr][col]=='p'){
                count++;
                break;
            }   
            }
          // Moving down 
                // Moving up
            for(int ptr=row+1;ptr<n;ptr++){
            if(board[ptr][col]=='B'){
                break;
            }
            else if(board[ptr][col]=='p'){
                count++;
                break;
            } 
        }
        return count;
    }
}
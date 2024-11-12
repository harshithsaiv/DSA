class Solution {
    public int[][] generateMatrix(int n) {
        int [][] result = new int[n][n];
        int cnt =1;
        for(int layer =0;layer<(n+1)/2;layer++){
            
            //Direction 1
            for(int ptr = layer;ptr<n-layer;ptr++){
                result[layer][ptr] = cnt;
                cnt++;
            }
            
            // Direction 2
            
            for(int ptr=layer+1;ptr<n-layer;ptr++){
                result[ptr][n-layer-1] = cnt;
                cnt++;
            }
            
            // Direction 3 
            for(int ptr= n-layer-2 ;ptr>=layer;ptr--){
                result[n-layer-1][ptr] = cnt;
                System.out.println(layer+"" +cnt);
                cnt++;
            }
            
            //Direction 4
            for(int ptr = n-layer-2 ; ptr>layer;ptr--){
                result[ptr][layer]= cnt;
                cnt++;
            }
        }
        return result;
    }
}
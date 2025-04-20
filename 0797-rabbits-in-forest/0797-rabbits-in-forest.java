class Solution {
    public int numRabbits(int[] answers) {

        int n = answers.length;
        int[] count = new int[1000];
        
        int ans = 0;
        for(int x:answers){
            if(++count[x] == 1)
                ans += x + 1;
            if(count[x] == x + 1)
                count[x] = 0;
        }
        
        return ans;
    }
}

// ex [1,1,2]
//count [0,0,0,0...] ; ans =0;
// count [0,1,0,0,...] ; count[1]==1 ans+=2;
// count [0,2,0,0,...] ; count[1]==0 
// count [0,0,1,0,...] ; count[2]==1 ans+=3;
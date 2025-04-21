class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // Brute Force : Approach O(n*(upper-lower+1))
        // int n= differences.length;
        // int count=0;
        // for(int i=lower;i<=upper;i++ ){
        //     int [] hidden = new int[n+1];
        //     hidden[0]=i;
        //     boolean flag = true;
        //     for(int j=1;j<n+1;j++){
        //         hidden[j] = hidden[j-1] + differences[j-1];
        //         if(hidden[j]<lower || hidden[j]>upper){
        //             flag = false;
        //         }
        //     }

        //     if(flag){
        //         count++;
        //     }
        // }
        // return count;
        long minPrefix = 0, maxPrefix = 0;   
        long prefix = 0;

        for (int d : differences) {
            prefix += d;
            minPrefix = Math.min(minPrefix, prefix);
            maxPrefix = Math.max(maxPrefix, prefix);
        }

        long left  = lower - minPrefix;       
        long right = upper - maxPrefix;      

        long ans = right - left + 1;          
        return (int) Math.max(ans, 0);
    }
}
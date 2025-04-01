class Solution {
    public long mostPoints(int[][] questions) {
        // Initial Approach
        // long maxPoints =0;
        // for(int j=0;j<questions.length;j++){
        //     long points =0;
        //     int d=0;
        //     for(int i=j;i<questions.length;i=i+d+1){
        //         d = questions[i][1];
        //         points+=questions[i][0];
        //     }
        //     maxPoints = Math.max(maxPoints,points);
        // }
        // return maxPoints;

        int n = questions.length;
        long dp[] = new long[n+1];
        dp[n]=0;

        for(int i=n-1;i>=0;i--){
            int d = questions[i][1];
            long pickValue = questions[i][0];
            if(i+d+1<n){
                pickValue += dp[i+d+1];
            }
            long skipValue = dp[i+1];
            dp[i]= Math.max(pickValue,skipValue);
        }

        long max =0;
        for(int i=0;i<n+1;i++){
            long val = dp[i];
            max = Math.max(val,max);
        }
        return max;
    }
}
class Solution {

    public int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length][2];
        return stocks(prices,0,0,dp);
    }

    public int stocks(int [] profit , int index , int buy,Integer dp[][]){
        int ans =0;
        if(index == profit.length){
            return 0;
        }

        if(dp[index][buy]!=null){
            return dp[index][buy];
        }

        if(buy==0){
           ans = Math.max( -profit[index] + stocks(profit,index+1,1,dp), 0 + stocks(profit,index+1,0,dp));
        }

        if(buy==1){
            ans = Math.max(profit[index]+ stocks(profit,index+1,0,dp), 0 + stocks(profit,index+1,1,dp));
        }
        return dp[index][buy] = ans;
    }
}
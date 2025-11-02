class Solution {
    public int maxProfit(int k,int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][k+1];
        return stocks(prices, 0, 1, k, dp);
    }

    private int stocks(int[] prices, int index, int buy, int cap, Integer[][][] dp) {
        if (cap == 0 || index == prices.length) return 0;

        if (dp[index][buy][cap] != null) return dp[index][buy][cap];

        int ans;
        if (buy == 1) {
            ans = Math.max(
                -prices[index] + stocks(prices, index + 1, 0, cap, dp),
                 0 + stocks(prices, index + 1, 1, cap, dp)
            );
        } else {
            ans = Math.max(
                prices[index] + stocks(prices, index + 1, 1, cap - 1, dp),
                0 + stocks(prices, index + 1, 0, cap, dp)
            );
        }

        dp[index][buy][cap] = ans;
        return ans;
    }
}

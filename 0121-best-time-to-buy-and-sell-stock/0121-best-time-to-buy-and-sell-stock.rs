impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let mut max_profit =0;
        let mut min =prices[0];
        
        for &price in prices.iter().skip(1){
            let profit = price - min;

            if profit > max_profit{
                max_profit = profit;
            }
            if price < min{
                min = price;
            }
        }
        max_profit
    }
}
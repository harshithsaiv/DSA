class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        
        for (int n : nums) {
            int count = 0;
            int currentSum = 0;
            
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    if (i * i == n) {
                        count += 1;
                        currentSum += i;
                    } else {
                        count += 2;
                        currentSum += i + (n / i);
                    }
                }
                
                if (count > 4) break;
            }
            
            if (count == 4) {
                totalSum += currentSum;
            }
        }
        
        return totalSum;
    }
}
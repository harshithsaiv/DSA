class Solution {
    public int getMaxLen(int[] nums) {
       int maxLen = 0;
        int start = 0; 
        int firstNegative = -1;
        int countNegative = 0;

        for(int i=0;i<nums.length;i++){  
             if (nums[i] == 0) {
                start = i + 1;
                firstNegative = -1;
                countNegative = 0;
            }
            else {
                if (nums[i] < 0) {
                    countNegative++;
                    if (firstNegative == -1) {
                        firstNegative = i;
                    }
                }
            if (countNegative % 2 == 0) {
                    maxLen = Math.max(maxLen, i - start + 1);
                } else {
                    maxLen = Math.max(maxLen, i - firstNegative);
                }
            }
        }
        return maxLen;
    }
}
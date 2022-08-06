class Solution {
    public int maxSubArray(int[] nums) {
        int i,j,sum=0,max=nums[0];
    for(i=0;i<nums.length;i++)
    {
        sum+=nums[i];
        max=Math.max(max,sum);
        if(sum<0)
            sum=0;
    }
return max;
}
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        int index=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
                return i;
            else if(nums[i]<target)
                index=i;
        }
        if(index==-1)
            return 0;
        return index+1;
    }
}
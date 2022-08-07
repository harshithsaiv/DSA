class Solution {
    public int searchInsert(int[] nums, int target) {
        int pos=0;
        pos=binary(nums,0,nums.length-1,target);
        return pos;
    }
        
    public int binary(int []nums,int low,int high,int target)
    {
            while(low<=high)
            {
                int mid=(low+high)/2;
                // if(nums[mid]==target)
                //     return mid;
                if(nums[mid]<target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        return low;
    }
}

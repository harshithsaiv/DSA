class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

         boolean search = true;
        while(search){
           search = binarySearch(nums,original);
           if(search){
                original = original *2;
           }
        }
        return original;
    }

    public boolean binarySearch(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2; 
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return false;
    }

}
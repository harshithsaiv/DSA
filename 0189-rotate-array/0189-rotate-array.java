class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
    for (int left = start, right = end; left < right; left++, right--) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    }

}

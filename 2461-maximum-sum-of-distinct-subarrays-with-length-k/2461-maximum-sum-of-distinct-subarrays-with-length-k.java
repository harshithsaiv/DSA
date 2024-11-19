import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // Add the current number to the window
            currentSum += nums[i];
            if (!window.add(nums[i])) { // Duplicate found
                // Remove elements from the start until duplicate is gone
                while (!window.add(nums[i])) {
                    currentSum -= nums[i - window.size()];
                    window.remove(nums[i - window.size()]);
                }
            }

            // Ensure the window size doesn't exceed k
            if (window.size() > k) {
                currentSum -= nums[i - k];
                window.remove(nums[i - k]);
            }

            // If the window size is exactly k, check for the max sum
            if (window.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}

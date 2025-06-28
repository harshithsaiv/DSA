class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0; 
        for (int i = n - k; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            cnt++;
            if (k == cnt) {
                break;
            }
        }

        int[] ans = new int[k];
        int p = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                ans[p++]=nums[i];
                if (map.get(nums[i])-1 == 0) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i])-1);
                }
            }
            if (p == k) {
                break;
            }
        }
        return ans;
    }
}

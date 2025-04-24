class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int total_distinct = distinctElement(nums);
        int count=0;
        for (int start = 0; start < nums.length; start++) {
            Set<Integer> set = new HashSet<>();
            for (int end = start ; end <nums.length; end++) {
                set.add(nums[end]);
                if(set.size()==total_distinct){
                    count++;
                }
            }
        }
        return count;
    }

    public int distinctElement(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num :nums){
            set.add(num);
        }

        return set.size();
    }
}
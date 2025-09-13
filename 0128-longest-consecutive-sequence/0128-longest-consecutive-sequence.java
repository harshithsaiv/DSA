class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num : nums){
            hset.add(num);
        }   

         int max = 0;
        for (int num : hset) {
            if (!hset.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (hset.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }
        return max;
    }
}
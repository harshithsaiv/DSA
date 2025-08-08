class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        int sum =0;
        //Brute Force
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         sum=nums[i]+nums[j];
        //         if(sum==target){
        //             result[0]=i;
        //             result[1]=j;
        //         }
        //     }
        // }
        // return result;
        //Optimized : HashMap
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        return new int[]{};
    }
}
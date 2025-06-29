class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); //Sort the array 
        int mod = 1000000007;
        int left =0;
        int right = nums.length-1;
        int [] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % mod;
            }   
        int count=0;
        while(left<=right){
            int sum=0;
            sum=nums[left]+nums[right];
            if(sum<=target){
                count=(count+power[(right-left)])%mod;
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int [] sum =new int[n+1];
        sum[0]=0;

        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1] +nums[i-1];
        }

        int count =0;
        for(int j=0;j<nums.length;j++){
            for(int i=j+1;i<=nums.length;i++){
                if(sum[i]-sum[j]==k){
                    count++;
                }
            }
        }

        return count;
    }
}
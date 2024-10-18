class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max =0;
        int sum=nums[0];
        for(int i=0;i<nums.length;i++){
           sum = sum | nums[i];
        }
        max= sum ;
        return countOr(nums,0,0,max);
    }
    
    public int countOr(int nums[], int index ,int currentOr , int targetOr ){
        if(index == nums.length){
            return ( currentOr == targetOr) ? 1:0;
        }
        
        int countWithout = countOr(nums,index+1,currentOr,targetOr);
        
        int countWith = countOr(nums,index+1,currentOr | nums[index],targetOr);
        
        return countWithout+ countWith;
    }
}

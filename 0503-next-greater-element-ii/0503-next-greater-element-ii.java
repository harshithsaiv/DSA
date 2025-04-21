class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int n= nums.length;
       int res[] = new int[n];

       Stack<Integer> stk = new Stack<>();
       Arrays.fill(res,-1);

       for(int i=0;i<2*n;i++){
        int num = nums[i%n];
        while(!stk.isEmpty() && num>nums[stk.peek()] ){
            int idx = stk.pop();
            res[idx] =num;
        }
            stk.push(i%n);
       }

       return res;
    }
}
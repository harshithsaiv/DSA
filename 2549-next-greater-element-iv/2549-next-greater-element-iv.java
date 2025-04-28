class Solution {
    public int[] secondGreaterElement(int[] nums) {
        // Time Complexity O(n^2)
        // int res[] = new int[nums.length];
        // Arrays.fill(res,-1);
        // int max =0;

        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[j]>nums[i]){
        //             if(++max==2){
        //                 res[i]=nums[j];
        //                 break;
        //             }
        //         }
        //     }
        //     max=0;
        // }
        // return res;

       int n = nums.length,  res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), tmp = new Stack<>();
        for (int i=0; i < n; i++) {
            while (!s2.empty() && nums[s2.peek()] < nums[i])
                res[s2.pop()] = nums[i];
            while (!s1.empty() && nums[s1.peek()] < nums[i])
                tmp.push(s1.pop());
            while (!tmp.empty())
                s2.push(tmp.pop());
            s1.push(i);
        }
        return res;
    }
}
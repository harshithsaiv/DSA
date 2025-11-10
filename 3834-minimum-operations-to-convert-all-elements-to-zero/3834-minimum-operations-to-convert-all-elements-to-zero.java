// class Solution {
//     public int minOperations(int[] nums) {
//         return peel(nums);
//     }
//     private int peel(int[] a) {
//         int n = a.length, i = 0;
//         while (i < n && a[i] == 0) i++;
//         if (i == n) return 0;

//         int j = i;
//         while (j < n && a[j] > 0) j++;  

//         int min = Integer.MAX_VALUE;
//         for (int k = i; k < j; k++) min = Math.min(min, a[k]);

//         for (int k = i; k < j; k++) if(a[k]==min) a[k]=0;
//         return 1 + peel(a);
//     }
// }

class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int n : nums) {
            while (!stack.isEmpty() && stack.peek() > n)
                stack.pop();
            if (n == 0)
                continue;
            if (stack.isEmpty() || stack.peek() < n) {
                res++;
                stack.push(n);
            }
        }
        return res;
    }
}

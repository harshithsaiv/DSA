class Solution {
    public int maxProduct(int[] nums) {
        int prod=0;
        PriorityQueue<Integer> max_heap= new PriorityQueue<>(Collections.reverseOrder());
        for(int n:nums){
            max_heap.add(n);
        }
        int num1 =max_heap.poll()-1;
        int num2 = max_heap.poll()-1;
        return num1*num2;
    }
}
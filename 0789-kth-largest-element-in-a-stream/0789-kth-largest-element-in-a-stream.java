class KthLargest {

    private PriorityQueue<Integer> min_heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        min_heap =new PriorityQueue<>();

        for(int num:nums){
            add(num);
        }
    }
    
    public int add(int val) {     
        min_heap.offer(val);  
        if(min_heap.size()>k){
            min_heap.poll();
        }
         return min_heap.peek(); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
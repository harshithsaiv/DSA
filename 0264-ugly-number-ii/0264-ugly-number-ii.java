class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> min_heap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        min_heap.add(1L);
        seen.add(1L);
        
        int[] factors = {2, 3, 5};
        long ugly = 1;
        
        for (int i = 1; i <= n; i++) {
            ugly = min_heap.poll(); 
            
            for (int factor : factors) {
                long nextUgly = ugly * factor;
                if (!seen.contains(nextUgly)) {
                    seen.add(nextUgly);
                    min_heap.add(nextUgly);
                }
            }
        }
        
        return (int) ugly;
    }
}
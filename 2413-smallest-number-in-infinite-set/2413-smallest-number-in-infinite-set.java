class SmallestInfiniteSet {

    private PriorityQueue<Integer> min_heap;
    private HashSet<Integer> inheap;
    private int smallest;
    public SmallestInfiniteSet() {
        min_heap=new PriorityQueue<>();
        inheap= new HashSet<>();
        smallest=1;

    }
    
    public int popSmallest() {
       if(!min_heap.isEmpty()){
        int small = min_heap.poll();
        inheap.remove(small);
        return small;
       }
       return smallest++;
    }
    
    public void addBack(int num) {
        if(!inheap.contains(num)&& num<smallest){
            min_heap.add(num);
            inheap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        int n=nums1.length;
        long max_score=0;
        int [][] pairs = new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i]=new int[]{nums1[i],nums2[i]};
        }
        Arrays.sort(pairs,(a,b)->b[1]-a[1]);

        long sum =0;
        for(int i=0;i<n;i++){
            min_heap.add(pairs[i][0]);
            sum+=pairs[i][0];
            if(min_heap.size()>k){
               sum -= min_heap.poll();
            }
           if (min_heap.size() == k) {
                max_score = Math.max(max_score, sum * pairs[i][1]);
            }
        }
        return max_score;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
       if(intervals.length ==0){
            return new int[0][0];
       }

       Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

       LinkedList<int[]> merged = new LinkedList<>();
       int [] currentInterval = intervals[0]; 
       merged.add(currentInterval);
       for(int i=1;i<intervals.length;i++){
            int [] interval = intervals[i];
            int currentEnd = currentInterval[1];
            int start = interval[0];
            int end = interval[1];

            if(start<=currentEnd){
                currentInterval[1] = Math.max(currentEnd,end);
            }
            else{
                currentInterval = interval;
                merged.add(interval);
                
            }
       }
       return merged.toArray(new int[merged.size()][]); 
    }
}
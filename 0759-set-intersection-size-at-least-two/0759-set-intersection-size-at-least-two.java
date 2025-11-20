class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Step 1 : Sort the array according to the second element
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return a[1] - b[1]; 
                }
                return b[0] - a[0]; 
            }
        });

        int setsize =0 ;

        int p1=-1;
        int p2=-1;

        for(int []interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(p1>=start && p2>=start){
                continue;
            }

            else if(p2>=start){
                p1=p2;
                p2 =end;
                setsize++;
            }
            else{
                p1=end-1;
                p2=end;
                setsize+=2;
            }
        }
        return setsize;
    }
}
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int [] ans = new int[spells.length];

        for(int i=0;i<spells.length;i++){
            int s = spells[i];
            int idx = first(potions,s,success);
            ans[i] = (idx==-1) ? 0:(m-idx);
        }
        return ans;
    }

    public int first(int[] potions, int s ,long success){
        int low=0,high=potions.length-1,idx=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            long prod = (long) potions[mid]*(long)s; //avoid overflow
            if(prod>=success){
                idx=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
            
        }
        return idx;
    }

}
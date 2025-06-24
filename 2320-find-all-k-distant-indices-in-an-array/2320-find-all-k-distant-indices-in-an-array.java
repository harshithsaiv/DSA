class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        ArrayList<Integer> keys = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                keys.add(i);
            }
        }

        Set<Integer> res = new HashSet<>();
        for(int j:keys){
            for(int i=0;i<nums.length;i++){
                if(Math.abs(i-j)<=k){
                    res.add(i);
                }
            }
        }
        ArrayList<Integer> fres = new ArrayList<>(res);
        Collections.sort(fres);
        System.out.println(res);
        return fres;
    }
}
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        ArrayList<Integer> keys = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                keys.add(i);
            }
        }

        Set<Integer> res = new HashSet<>();
        for (int j : keys) {
            int start = Math.max(0, j - k);
            int end = Math.min(nums.length - 1, j + k);
            for (int i = start; i <= end; i++) {
                res.add(i);
            }
        }
        
        ArrayList<Integer> fres = new ArrayList<>(res);
        Collections.sort(fres);
        System.out.println(res);
        return fres;
    }
}
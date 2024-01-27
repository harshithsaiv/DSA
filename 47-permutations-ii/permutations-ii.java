class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
          List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean used[] = new boolean[nums.length];
        ArrayList<Integer> permutation = new ArrayList<Integer>();
        backtrack(res, nums, permutation, used);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            if(!res.contains(permutation))
            res.add(new ArrayList<>(permutation)); 
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                backtrack(res, nums, permutation, used);
                // undo the choice
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
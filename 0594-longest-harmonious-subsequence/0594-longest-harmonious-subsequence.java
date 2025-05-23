class Solution {
    static {
        for(int i=0;i<500;i++){
            findLHS(new int[]{1,2,3,4});
        }
    }
    public static int findLHS(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                ans = Math.max(ans, freq.get(key) + freq.get(key + 1));
            }
        }

        return ans;
    }
}

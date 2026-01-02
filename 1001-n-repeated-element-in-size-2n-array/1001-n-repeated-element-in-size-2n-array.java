import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {
        int length = nums.length;
        int target = length / 2;

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            if (e.getValue() == target) {
                return e.getKey();
            }
        }
        return -1;
    }
}

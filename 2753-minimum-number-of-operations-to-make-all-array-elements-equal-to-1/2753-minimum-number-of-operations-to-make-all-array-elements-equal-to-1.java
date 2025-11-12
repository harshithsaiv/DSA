import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int ones = 0;
        for (int x : nums) if (x == 1) ones++;
        if (ones > 0) return n - ones;


        int gAll = 0;
        for (int x : nums) gAll = gcd(gAll, x);
        if (gAll != 1) return -1;

        int best = Integer.MAX_VALUE;

        // prev: gcd -> minimal length for subarrays ending at previous index
        Map<Integer, Integer> prev = new HashMap<>();
        Map<Integer, Integer> curr = new HashMap<>();

        for (int x : nums) {
            curr.clear();
            // Start a new subarray at this position
            curr.put(x, 1);

            // Extend all previous subarrays by x
            for (Map.Entry<Integer, Integer> e : prev.entrySet()) {
                int ng = gcd(e.getKey(), x);
                int len = e.getValue() + 1;
                Integer old = curr.get(ng);
                if (old == null || len < old) curr.put(ng, len);
            }

            Integer len1 = curr.get(1);
            if (len1 != null) best = Math.min(best, len1);

            // Move forward
            Map<Integer, Integer> tmp = prev; prev = curr; curr = tmp;
        }

        // To create the first 1: best - 1 ops, then spread: n - 1 ops
        return n + best - 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}

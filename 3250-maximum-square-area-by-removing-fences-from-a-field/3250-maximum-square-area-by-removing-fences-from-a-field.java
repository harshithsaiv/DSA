import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long[] h = augmentFences(m, hFences);
        long[] v = augmentFences(n, vFences);
        
        Set<Long> hGaps = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hGaps.add(Math.abs(h[i] - h[j]));
            }
        }

        long maxSide = -1;
        // Check all possible vertical gaps
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                long gap = Math.abs(v[i] - v[j]);
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        if (maxSide == -1) return -1;

        // Return area modulo 10^9 + 7
        long MOD = 1_000_000_007;
        return (int) ((maxSide * maxSide) % MOD);
    }

    private long[] augmentFences(int boundary, int[] fences) {
        long[] augmented = new long[fences.length + 2];
        for (int i = 0; i < fences.length; i++) augmented[i] = fences[i];
        augmented[fences.length] = 1;
        augmented[fences.length + 1] = boundary;
        return augmented;
    }
}
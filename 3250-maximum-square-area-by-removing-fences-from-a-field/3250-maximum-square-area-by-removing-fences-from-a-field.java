import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hList = new ArrayList<>();
        for (int h : hFences) hList.add(h);
        hList.add(1);
        hList.add(m);

        List<Integer> vList = new ArrayList<>();
        for (int v : vFences) vList.add(v);
        vList.add(1);
        vList.add(n);


        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < hList.size(); i++) {
            for (int j = i + 1; j < hList.size(); j++) {
                hGaps.add(Math.abs(hList.get(i) - hList.get(j)));
            }
        }

        long maxSide = -1;
        for (int i = 0; i < vList.size(); i++) {
            for (int j = i + 1; j < vList.size(); j++) {
                int gap = Math.abs(vList.get(i) - vList.get(j));
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, (long) gap);
                }
            }
        }

        
        if (maxSide == -1) return -1;
        
        long MOD = 1_000_000_007;
        return (int) ((maxSide * maxSide) % MOD);
    }
}
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Step 1: Deduplicate and map numbers to indices
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, index++);
            }
        }

        // Step 2: Initialize UnionFind with unique size
        UnionFind UF = new UnionFind(map.size());

        // Step 3: For each num, if num+1 exists, union them
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                UF.unionSet(map.get(num), map.get(num + 1));
            }
        }

        // Step 4: Find largest set size
        int max = 1;
        for (int idx : map.values()) {
            max = Math.max(max, UF.sizeOfSet(idx));
        }

        return max;
    }
}

// --- Your DSU Implementation (slightly reused) ---
class UnionFind {
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<>(N);
        rank = new ArrayList<>(N);
        setSize = new ArrayList<>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i) return i;
        int ret = findSet(p.get(i));
        p.set(i, ret);
        return ret;
    }

    public boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            numSets--;
            int x = findSet(i), y = findSet(j);
            if (rank.get(x) > rank.get(y)) {
                p.set(y, x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            } else {
                p.set(x, y);
                setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x).equals(rank.get(y))) {
                    rank.set(y, rank.get(y) + 1);
                }
            }
        }
    }

    public int sizeOfSet(int i) {
        return setSize.get(findSet(i));
    }
}

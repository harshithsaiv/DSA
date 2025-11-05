import java.util.*;

class Solution {

    // ----- per-call state -----
    private Map<Integer, Integer> cnt;
    private TreeSet<Node> big, small;
    private Map<Integer, Node> nodeByVal;
    private Set<Integer> inBig;
    private long sumBig;
    private int needX;

    // Node ordered by (freq desc, value desc)
    private static final Comparator<Node> BY_DESC = (a, b) -> {
        if (a.f != b.f) return Integer.compare(b.f, a.f);
        if (a.v != b.v) return Integer.compare(b.v, a.v);
        return 0;
    };

    private static class Node {
        int f, v;
        Node(int f, int v) { this.f = f; this.v = v; }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        if (k > n) return new long[0];

        // init state
        this.cnt = new HashMap<>();
        this.big = new TreeSet<>(BY_DESC);
        this.small = new TreeSet<>(BY_DESC);
        this.nodeByVal = new HashMap<>();
        this.inBig = new HashSet<>();
        this.sumBig = 0L;
        this.needX = x;

        // build first window
        for (int i = 0; i < k; i++) {
            addOne(nums[i]);
        }
        rebalance();

        long[] ans = new long[n - k + 1];
        ans[0] = sumBig;

        // slide
        for (int i = k; i < n; i++) {
            removeOne(nums[i - k]);
            addOne(nums[i]);
            rebalance();
            ans[i - k + 1] = sumBig;
        }
        return ans;
    }

    // ----- helpers -----

    private void addOne(int v) {
        int old = cnt.getOrDefault(v, 0);
        if (old > 0) removeNode(v);
        int now = old + 1;
        cnt.put(v, now);
        insertNode(v, now);
    }

    private void removeOne(int v) {
        int f = cnt.get(v);
        removeNode(v);
        if (f == 1) {
            cnt.remove(v);
        } else {
            int nf = f - 1;
            cnt.put(v, nf);
            insertNode(v, nf);
        }
    }

    private void insertNode(int v, int f) {
        Node nd = new Node(f, v);
        small.add(nd);                // default to small; rebalance may promote
        nodeByVal.put(v, nd);
        inBig.remove(v);
    }

    private void removeNode(int v) {
        Node nd = nodeByVal.get(v);
        if (nd == null) return;
        if (inBig.contains(v)) {
            if (big.remove(nd)) sumBig -= 1L * nd.f * nd.v;
            inBig.remove(v);
        } else {
            small.remove(nd);
        }
        nodeByVal.remove(v);
    }

    private void rebalance() {
        int need = Math.min(needX, nodeByVal.size());

        // promote best from small until big has 'need'
        while (big.size() < need && !small.isEmpty()) {
            Node take = small.pollFirst();
            big.add(take);
            sumBig += 1L * take.f * take.v;
            inBig.add(take.v);
        }

        // demote worst if big has too many
        while (big.size() > need) {
            Node drop = big.pollLast();
            sumBig -= 1L * drop.f * drop.v;
            small.add(drop);
            inBig.remove(drop.v);
        }

        // swap while the best in small outranks the worst in big
        while (!small.isEmpty() && !big.isEmpty()) {
            Node bestSmall = small.first();
            Node worstBig  = big.last();
            // BY_DESC: negative => first should come before second (i.e., better)
            if (BY_DESC.compare(bestSmall, worstBig) < 0) {
                small.pollFirst();
                big.add(bestSmall);
                sumBig += 1L * bestSmall.f * bestSmall.v;
                inBig.add(bestSmall.v);

                big.pollLast();
                sumBig -= 1L * worstBig.f * worstBig.v;
                small.add(worstBig);
                inBig.remove(worstBig.v);
            } else break;
        }

        // If small is empty and big still < need, that's fine (not enough uniques).
    }
}

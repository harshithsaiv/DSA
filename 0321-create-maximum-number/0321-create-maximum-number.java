class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int start = Math.max(0, k - n);
        int end = Math.min(k, m);
        int[] best = new int[0];

        for (int i = start; i <= end; i++) {
            int[] a = maxSubseq(nums1, i);
            int[] b = maxSubseq(nums2, k - i);
            int[] cand = merge(a, b, k);
            if (greaterTail(cand, 0, best, 0)) best = cand;
        }
        return best;
    }

    // Pick the lexicographically maximum subsequence of length t using a monotonic stack
    private int[] maxSubseq(int[] arr, int t) {
        if (t == 0) return new int[0];
        int drops = arr.length - t;
        int[] stack = new int[arr.length];
        int top = 0;

        for (int x : arr) {
            while (drops > 0 && top > 0 && stack[top - 1] < x) {
                top--;
                drops--;
            }
            stack[top++] = x;
        }
        // copy first t elements
        return Arrays.copyOf(stack, t);
    }

    // Merge two subsequences into the lexicographically largest sequence
    private int[] merge(int[] a, int[] b, int k) {
        int i = 0, j = 0, p = 0;
        int[] out = new int[k];
        while (p < k) {
            if (greaterTail(a, i, b, j)) {
                out[p++] = a[i++];
            } else {
                out[p++] = b[j++];
            }
        }
        return out;
    }

    // Return true if a[i:] > b[j:] lexicographically
    private boolean greaterTail(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++; j++;
        }
        if (j == b.length) return true;      // b exhausted -> a is greater or equal
        if (i == a.length) return false;     // a exhausted -> b is greater
        return a[i] > b[j];
    }
}
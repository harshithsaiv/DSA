class Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        // 1) Build the list of run-lengths L_i
        List<Integer> runs = new ArrayList<>();
        int n = word.length();
        for (int i = 0; i < n; ) {
            char c = word.charAt(i);
            int j = i + 1;
            while (j < n && word.charAt(j) == c) j++;
            runs.add(j - i);
            i = j;
        }
        int m = runs.size();

        // 2) Precompute total # of sequences = â (L_i)
        //    where each run of length L_i can yield x_i â [1..L_i]
        long total = 1;
        for (int L : runs) {
            total = total * L % MOD;
        }

        // 3) If m >= k, then even picking x_i = 1 for all i gives sum â¥ m â¥ k,
        //    so every choice is valid:
        if (m >= k) {
            return (int) total;
        }

        // 4) Otherwise, we need to count how many choices have sum x_i â¥ k.
        //    Let R_i = L_i - 1 and y_i = x_i - 1 â [0..R_i]. We need sum y_i â¥ (k - m).
        int S = k - m;  // threshold on sum of y_i
        // dp[j] = number of ways to have sum y = j after processing some runs
        int[] dp = new int[S];
        dp[0] = 1;

        // 5) For each run, do a slidingâwindow prefixâsum to update dp up to j < S
        for (int L : runs) {
            int R = L - 1;
            // build prefix sums of old dp
            long window = 0;
            int[] next = new int[S];
            for (int j = 0; j < S; j++) {
                // add dp[j] into sliding window
                window = (window + dp[j]) % MOD;
                // remove dp[j - (R+1)] when window too large
                if (j - (R + 1) >= 0) {
                    window = (window - dp[j - (R + 1)] + MOD) % MOD;
                }
                next[j] = (int) window;
            }
            dp = next;
        }

        // 6) Count invalid = â_{j=0..S-1} dp[j]
        long invalid = 0;
        for (int j = 0; j < S; j++) {
            invalid = (invalid + dp[j]) % MOD;
        }

        // 7) Answer = total_sequences â invalid (mod MOD)
        //    (invalid counts those with sum y < S â sum x < k)
        long ans = (total - invalid + MOD) % MOD;
        return (int) ans;
    }
}

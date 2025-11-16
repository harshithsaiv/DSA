class Solution {
    private static final long MOD = 1_000_000_007L;

    public int numSub(String s) {
        long ans = 0L;
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '0') { i++; continue; }
            int j = i;
            while (j < n && s.charAt(j) == '1') j++;
            long L = j - i;
            ans = (ans + L * (L + 1) / 2) % MOD;
            i = j;
        }
        return (int) ans;
    }
}

class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        if (n == 2) return s.charAt(0) == s.charAt(1);

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.charAt(i) - '0';

        while (n > 2) {
            int[] b = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                b[i] = (a[i] + a[i + 1]) % 10;
            }
            a = b;
            n--;
        }

        return a[0] == a[1];
    }
}

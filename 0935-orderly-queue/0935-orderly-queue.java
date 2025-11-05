class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            return new String(a);
        }
        // k == 1: smallest rotation
        return smallestRotationBooth(s);
        
    }

    // private String smallestRotationSimple(String s) {
    //     String best = s;
    //     for (int i = 1; i < s.length(); i++) {
    //         String rot = s.substring(i) + s.substring(0, i);
    //         if (rot.compareTo(best) < 0) best = rot;
    //     }
    //     return best;
    // }

    private String smallestRotationBooth(String s) {
        String ss = s + s;
        int n = s.length();
        int i = 0, j = 1, k = 0;

        while (i < n && j < n && k < n) {
            char a = ss.charAt(i + k), b = ss.charAt(j + k);
            if (a == b) {
                k++;
            } else if (a > b) {
                i = i + k + 1;
                if (i == j) i++;
                k = 0;
            } else {
                j = j + k + 1;
                if (i == j) j++;
                k = 0;
            }
        }
        int start = Math.min(i, j);
        return ss.substring(start, start + n);
    }
}
class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            return new String(a);
        }
        // k == 1: smallest rotation
        return smallestRotationSimple(s);
        
    }

    private String smallestRotationSimple(String s) {
        String best = s;
        for (int i = 1; i < s.length(); i++) {
            String rot = s.substring(i) + s.substring(0, i);
            if (rot.compareTo(best) < 0) best = rot;
        }
        return best;
    }
}
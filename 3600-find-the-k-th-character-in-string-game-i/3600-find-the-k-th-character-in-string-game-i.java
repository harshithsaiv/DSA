class Solution {
    public char kthCharacter(int k) {
        StringBuilder str = new StringBuilder();
        str.append("a");
        while(str.length()<k){
            str = compute(str);
        }
        return str.charAt(k-1);
    }

    
    private StringBuilder compute(StringBuilder sb) {
        StringBuilder res = new StringBuilder(sb);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            char next = (char)('a' + (c - 'a' + 1) % 26);
            res.append(next);
        }
        return res;
    }
}
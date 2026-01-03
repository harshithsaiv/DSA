class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            int revIndex = 26 - (ch[i] - 'a');
            sum += revIndex * (i + 1);
        }

        return sum;
    }
}

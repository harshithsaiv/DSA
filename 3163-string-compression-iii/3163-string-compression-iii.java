class Solution {
    public String compressedString(String word) {
        
        StringBuilder comp = new StringBuilder("");
        int pos =0;
        while(pos<word.length()){
            char currentChar = word.charAt(pos);
            int consecutivechar = 0;
            while(pos<word.length() && consecutivechar<9 && currentChar==word.charAt(pos)){
                consecutivechar++;
                pos++;
            }
            comp.append(consecutivechar).append(currentChar);
        }
        return comp.toString();
    }
}
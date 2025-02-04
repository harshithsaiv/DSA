class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res=new StringBuilder();
        int j=0;

        for(int i=0;i<word1.length();i++){
            res.append(word1.charAt(i));
            if(j<word2.length()){
                res.append(word2.charAt(j));
                j++;
            }
        }
        while(j<word2.length()){
                res.append(word2.charAt(j));
                j++;
            }
        return res.toString();
    }
}
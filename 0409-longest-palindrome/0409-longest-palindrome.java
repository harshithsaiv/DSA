class Solution {
    public int longestPalindrome(String s) {
       int [] charCount = new int[100];
        for(char ch : s.toCharArray()){
            int index = ch-'A';
            charCount[index]++;
        }
        
        boolean oddCount=false;
        int res =0;
        for(int val : charCount){
            if(val%2==0){
                res+=val;
            }
            else{
                res+=val-1;
                oddCount = true;
            }
        }
        if(oddCount){
            res+=1;
        }
        return res;
    }
}
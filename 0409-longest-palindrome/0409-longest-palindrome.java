class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> count = new HashMap<>();
        for(char ch : s.toCharArray()){
            count.put(ch,count.getOrDefault(ch,0)+1);
        }
        
        boolean oddCount=false;
        int res =0;
        for(int val : count.values()){
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
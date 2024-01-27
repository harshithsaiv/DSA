class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        String s1=""+x;
        String s2="";
        if(x>0)
        {
            while(n>0)
            {
                s2+=n%10;
                n=n/10;
            }
            if(s1.equals(s2))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(x==0)
        {
            return true;
        }
        return false;
        
    }
}
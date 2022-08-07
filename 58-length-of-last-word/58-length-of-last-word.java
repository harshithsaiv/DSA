class Solution {
    public int lengthOfLastWord(String s) {
       int c=0,pos=0;
       for(int i=s.length()-1;i>=0;i--)
       {
            if(s.charAt(i)!=' ')
            {
                pos=i;
                break;
            }
                
       }
        System.out.println(pos);
        for(int i=pos;i>=0;i--)
        {
            if(s.charAt(i)!=' ')
                c++;
            else
                break;
        }
        return c;
    }
}
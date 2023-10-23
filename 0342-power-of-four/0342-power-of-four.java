class Solution {
    public boolean isPowerOfFour(int n) {
        int num=n;
        if(num==1)
        {
            return true;
        }
        else
        {
            while(num!=0 && num%4==0)
            {
                if(num/4==1 && num%4==0 )
                {
                    return true;
                }
                num=num/4;
            }
        }
        return false;
    }
}
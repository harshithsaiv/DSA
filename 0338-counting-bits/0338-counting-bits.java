class Solution {
    public int[] countBits(int n) {
        int a[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int k=i;
            int count_1=0;
            while(k!=0)
            {
                if(k%2==1)
                {
                    count_1++;
                }
                k=k/2;
            }
            a[i]=count_1;
        }
        return a;
    }
}
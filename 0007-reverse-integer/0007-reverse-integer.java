class Solution {
    public int reverse(int x) {
        String res="";
        double result=0;
        if(x>2147483647 || x<-2147483647)
            return 0;
        if(x<0)
        {
           int intr=x-(2*x);
            System.out.println(intr);
            while(intr>0)
            {
                res+=intr%10;
                intr=intr/10;
            }
            result = Double.parseDouble(res);
            result=result-(2*result);
        }
        else if(x==0)
        {
            return 0;
        }
        else
        {
            while(x>0)
            {
                res+=x%10;
                x=x/10;
            }
         result = Double.parseDouble(res);
        }
        if(result>2147483647 || result<-2147483648)
            return 0;
        return (int)result;
    }
}
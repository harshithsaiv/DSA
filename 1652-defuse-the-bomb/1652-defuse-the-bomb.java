class Solution {
    public int[] decrypt(int[] code, int k) {
        int res [] = new int [code.length];
        if(k==0)
            return res;
        else if(k>0){
            int [] window = new int[k];
            for(int i=0;i<code.length;i++){
                int sum=0;
                for(int j=1;j<=k;j++){
                    sum+=code[(i+j)%code.length];
                }
                res[i]=sum;
            }
        }
        else if(k<0){
            for(int i=0;i<code.length;i++){
                int sum=0;
                for(int j=i-Math.abs(k);j<i;j++){
                    sum+=code[(j+code.length)%code.length];
                }
                res[i]=sum;
        }
    
    }
        return res;
}
}
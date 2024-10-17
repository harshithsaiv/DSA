class Solution {
    public int maximumSwap(int num) {
        int max = num;
        String str = Integer.toString(num);
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                char [] cnum = str.toCharArray();
                if(cnum[j]>cnum[i]){
                    char temp = cnum[i];
                    cnum[i]=cnum[j];
                    cnum[j]=temp;
                    int x = Integer.parseInt(new String(cnum));
                     max = Math.max(x,max);
                } 
            }
        }
        return max;
    }
}
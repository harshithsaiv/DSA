class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int num = bits.length;
        int i=0;

        while(i<num-1){
            if(bits[i]==1) i+=2;
            else i+=1;
        }
        return i==num-1;
    }
}
class Solution {
    public int countOperations(int num1, int num2) {
            if(num1==0 || num2==0){
                return 0;
            }
            int sum =0;
            int rem = Math.max(num1,num2) % Math.min(num1,num2);
            int quo = Math.max(num1,num2) / Math.min(num1,num2);
            if(rem==0){
                return quo;
            }

            else{
                sum+=quo + countOperations(rem,Math.min(num1,num2));
            }
        return sum;
    }
}
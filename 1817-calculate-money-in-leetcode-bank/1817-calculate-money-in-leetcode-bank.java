class Solution {
    public int totalMoney(int n) {
        int result =0;
        int d = n/7;
        int r = n%7;
        int dollar = 1;
        while(d!=0){
            result+=(7*(dollar+(dollar+6))/2);
            dollar = dollar+1;
            d--;
        }
        System.out.println(dollar);
        System.out.println(r);
        System.out.println(d);
        System.out.println(result);
        while(r!=0){
            result+=dollar;
            dollar++;
            r--;
        } 
        return result;
    }
}
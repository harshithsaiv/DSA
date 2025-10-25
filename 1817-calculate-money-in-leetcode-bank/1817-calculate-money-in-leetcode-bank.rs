impl Solution {
    pub fn total_money(n: i32) -> i32 {
        let mut dollar =1;
        let mut d = n/7;
        let mut r = n%7;
        let mut result =0;
        while(d!=0){
            result += (7*(dollar+(dollar+6))/2);
            d-=1;
            dollar=dollar+1;
        }

        while(r!=0){
            result+=dollar;
            dollar+=1;
            r-=1;
        }
        result
    }
}
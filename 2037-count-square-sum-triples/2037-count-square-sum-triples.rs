impl Solution {
    pub fn count_triples(n: i32) -> i32 {
        let mut count =0;
        for i in 1..=n {
            for j in i+1..=n{
                let sum_square = (i*i) + (j*j);
                let mut c = (sum_square as f64).sqrt() as i32;

                if(c<=n && c*c==sum_square){
                    count =count+1;
                }
            }
        }
        count*2
    }
}
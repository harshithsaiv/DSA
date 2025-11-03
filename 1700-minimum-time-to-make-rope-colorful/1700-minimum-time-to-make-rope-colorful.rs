impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        let mut total=0;
        let bytes = colors.as_bytes();
        let mut max_group = needed_time[0];

         for i in 1..bytes.len() {
            if bytes[i] == bytes[i - 1] {
                total += needed_time[i].min(max_group);
                max_group = max_group.max(needed_time[i]);
            } else {
                max_group = needed_time[i];
            }
        }

        total
    }
}
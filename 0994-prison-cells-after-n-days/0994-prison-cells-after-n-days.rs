use std::collections::HashMap;

impl Solution {
    pub fn prison_after_n_days(mut cells: Vec<i32>, mut n: i32) -> Vec<i32> {
        let mut seen: HashMap<Vec<i32>, i32> = HashMap::new();

        while n > 0 {

            if let Some(&prev_n) = seen.get(&cells) {
                let cycle_len = prev_n - n;
                if cycle_len != 0 {
                    n %= cycle_len;
                }
            }

            seen.insert(cells.clone(), n);

            if n == 0 {
                break;
            }

            n -= 1;
            cells = Self::next_day(&cells);
        }

        cells
    }

    fn next_day(cells: &Vec<i32>) -> Vec<i32> {
        let mut next = vec![0; 8]; 
        for i in 1..7 {
            next[i] = if cells[i - 1] == cells[i + 1] { 1 } else { 0 };
        }

        next
    }
}

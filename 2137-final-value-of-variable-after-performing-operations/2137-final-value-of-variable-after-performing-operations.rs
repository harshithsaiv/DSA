impl Solution {
    pub fn final_value_after_operations(operations: Vec<String>) -> i32 {
        let mut x:i32=0;
        for operation in &operations{
            if operation == "--X" || operation =="X--"{
                x=x-1;
            }
            else{
                x=x+1;
            }
        }
        x
    }
}
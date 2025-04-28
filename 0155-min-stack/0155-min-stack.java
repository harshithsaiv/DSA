class MinStack {


    private Stack<Long> stk;
    private long min =0;
    public MinStack() {
        stk = new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val){
        if(stk.isEmpty()){
            min =val;
            stk.push((long)val);
        }
        else{
            if(val>min){
                stk.push((long)val);
            }
            else{
                stk.push((long)2*val-min);
                min = val;
            }
        }
    }
    
    public void pop() {
        if(stk.isEmpty()){
            return;
        }

        long n = stk.peek();
        stk.pop();
        if(n<min){
            min = 2*min-n;
        }
        if (stk.isEmpty()) {   
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        long n = stk.peek();
        if(n<min){
            return (int)min;
        }
        else{
            return (int)n;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

// This method has Time complexity of O(1) but Space complexity is O(2*n);
// class MinStack {
//     private Stack<int[]> stk;
//     public MinStack() {
//         stk = new Stack<>();
//     }
    
//     public void push(int val) {
//         if(stk.isEmpty()){
//             stk.push(new int[]{val,val});
//         }
//         else{
//             int prev_min = stk.peek()[1];
//             stk.push(new int[]{val,Math.min(val,prev_min)});
//         }
//     }
    
//     public void pop() {
//         stk.pop();
//     }
    
//     public int top() {

//         return stk.peek()[0];
//     }
    
//     public int getMin() {
//         return stk.peek()[1];
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
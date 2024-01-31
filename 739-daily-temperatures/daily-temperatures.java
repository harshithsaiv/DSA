// Approach 1 -----brute force
// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int highest=0;
//         int [] answers= new int[temperatures.length];
//         for(int i=0;i<temperatures.length;i++)
//         {
//             highest=temperatures[i];
//             int days=0;
//             boolean flg=false;
//             for(int j=i;j<temperatures.length;j++)
//             {
//                 if(temperatures[j]>highest)
//                 {
//                     flg=true;
//                     break;
//                 }
//                 days++;
//             }
//             if(flg)
//             {
//                 answers[i]=days;
//             }
//             else
//             {
//                 answers[i]=0;
//             }    
//         }
//         return answers;
//     }
// }

import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stk.isEmpty() && T[stk.peek()] < T[i]) {
                int index = stk.pop();
                result[index] = i - index;
            }
            stk.push(i);
        }
        return result;
    }
}


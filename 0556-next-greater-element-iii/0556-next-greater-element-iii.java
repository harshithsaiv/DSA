class Solution {

    public int nextGreaterElement(int n) {
         char[] number = (n + "").toCharArray();
        
        int i, j;
        // I) Start from the right most digit and 
        // find the first digit that is
        // smaller than the digit next to it.
        for (i = number.length-1; i > 0; i--)
            if (number[i-1] < number[i])
               break;

        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;
            
         // II) Find the smallest digit on right side of (i-1)'th 
         // digit that is greater than number[i-1]
        int x = number[i-1], smallest = i;
        for (j = i+1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;
        
        // III) Swap the above found smallest digit with 
        // number[i-1]
        char temp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = temp;
        
        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(number, i, number.length);
        
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}

// This approach takes O(k!*k) k-> length of n 
//    public int nextGreaterElement(int n) {
//     char[] digits = Integer.toString(n).toCharArray();
//     Set<Integer> arr = new HashSet<>();
//     permute(digits, 0, arr);
    
//     long ans = Long.MAX_VALUE;
//     for (int num : arr) {
//         if (num > n && num < ans) {
//             ans = num;
//         }
//     }
    
//     return (ans == Long.MAX_VALUE || ans > Integer.MAX_VALUE) ? -1 : (int) ans;
// }

// private void permute(char[] digits, int index, Set<Integer> arr) {
//     if (index == digits.length) {
//         String numStr = new String(digits);
//         int num = Integer.parseInt(numStr);
//         arr.add(num);
//         return;
//     }
    
//     for (int i = index; i < digits.length; i++) {
//         swap(digits, index, i);
//         permute(digits, index + 1, arr);
//         swap(digits, index, i);
//     }
// }

// private void swap(char[] arr, int i, int j) {
//     char temp = arr[i];
//     arr[i] = arr[j];
//     arr[j] = temp;
// }

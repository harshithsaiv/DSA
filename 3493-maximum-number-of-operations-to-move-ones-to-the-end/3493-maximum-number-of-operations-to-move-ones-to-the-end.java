// class Solution {
//     public int maxOperations(String s) {
//         int prefix = 0;
//         char []chars= s.toCharArray();
//         int n = s.length();
//         int [] arr = new int[n];
//         int []prefixSum = new int[n];
//         for(int i=0;i<n;i++){
//             if(chars[i]=='1'){
//                 arr[i]=1;
//             }
//             else{
//                 arr[i]=0;
//             }
//         }

//         prefixSum[0]=arr[0];

//         for(int i=1;i<n;i++){
//             prefixSum[i] = prefixSum[i-1]+arr[i];
//         }

//         int count =0;
//         HashSet<Integer> set = new HashSet<>();
//         for(int i=0;i<n;i++){
//             if(arr[i]==0){
//                 set.add(prefixSum[i]);
//             }
//         }

//         for(int num:set){
//             count+=num;
//         }
//         return count;
//     }
// }

class Solution {
    public int maxOperations(String s) {
        int ones = 0;                    // current prefix count of '1's
        boolean[] seen = new boolean[s.length() + 1];  // seen[k] = some zero had k ones before it

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else { // char == '0'
                seen[ones] = true;
            }
        }

        int ans = 0;
        for (int k = 0; k <= ones; k++) {
            if (seen[k]) ans += k;
        }
        return ans;
    }
}

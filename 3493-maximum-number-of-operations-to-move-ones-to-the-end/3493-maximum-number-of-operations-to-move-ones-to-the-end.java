class Solution {
    public int maxOperations(String s) {
        int prefix = 0;
        char []chars= s.toCharArray();
        int n = s.length();
        int [] arr = new int[n];
        int []prefixSum = new int[n];
        for(int i=0;i<n;i++){
            if(chars[i]=='1'){
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
        }

        prefixSum[0]=arr[0];

        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }

        int count =0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                set.add(prefixSum[i]);
            }
        }

        for(int num:set){
            count+=num;
        }
        return count;
    }
}
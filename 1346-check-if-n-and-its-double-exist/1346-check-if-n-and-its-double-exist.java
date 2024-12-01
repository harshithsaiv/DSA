class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hs.put(arr[i],i);
        }
        for(int j=0;j<arr.length;j++){
            int elem = 2*arr[j];
            if(hs.containsKey(elem)){
                if(hs.get(elem)!=j)
                    return true;
            }
        }
        return false;
    }
}
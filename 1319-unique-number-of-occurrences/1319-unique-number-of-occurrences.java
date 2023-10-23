class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hash= new HashMap<>();
        for(int i : arr)
        {
            int count= hash.containsKey(i) ? hash.get(i) : 0;
            hash.put(i,count+1);
        }
        System.out.println(hash.entrySet());
        for(int i : hash.values())
        {
            int count=0;
            for(int j: hash.values())
            {
                if(i==j)
                {
                    count++;
                }
            }
            if(count>1)
            {
                return false;
            }
        }
        return true;
    }
}
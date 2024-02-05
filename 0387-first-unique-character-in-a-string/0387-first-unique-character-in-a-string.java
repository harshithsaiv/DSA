class Solution {
    public int firstUniqChar(String s) {
        
        LinkedHashMap<Character,Integer> hmap = new LinkedHashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            if(hmap.containsKey(ch))
            {
                int count = hmap.get(ch);
                hmap.put(ch,count+1);
            }
            else
            {
                hmap.put(ch,1);
            }
        }
        for(int i=0;i<s.length();i++) {
            if(hmap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
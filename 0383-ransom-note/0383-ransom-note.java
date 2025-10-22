class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> rnote = new HashMap<>();
        HashMap<Character,Integer> mnote = new HashMap<>();
        
        char []rchars = ransomNote.toCharArray();
        char []mchars = magazine.toCharArray();
        for(char ch : rchars){
            rnote.put(ch,rnote.getOrDefault(ch,0)+1);
        }

        for(char ch : mchars){
            mnote.put(ch,mnote.getOrDefault(ch,0)+1);
        }
        
        for (Map.Entry<Character,Integer> e : rnote.entrySet()) {
            if (mnote.getOrDefault(e.getKey(), 0) < e.getValue()) return false;
        }
        return true;
    }
}
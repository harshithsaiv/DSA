import java.util.ArrayList;

class Solution {
    public String reverseWords(String s) {
        ArrayList<String> res = new ArrayList<>();
        
        s = s.trim();
    
        String ss = "";
        
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                ss += s.charAt(i); 
            } else if (ss.length() > 0) { 
                res.add(ss); 
                ss = "";
                while (i + 1 < s.length() && s.charAt(i + 1) == ' ') { 
                    i++;
                }
            }
        }
        
        
        if (ss.length() > 0) {
            res.add(ss);
        }
        
        StringBuilder ret = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            ret.append(res.get(i));
            if (i != 0) {
                ret.append(" ");             }
        }
        
        return ret.toString();
    }
}

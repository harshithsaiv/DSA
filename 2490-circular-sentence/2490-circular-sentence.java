class Solution {
    public boolean isCircularSentence(String sentence) {
        String [] words =   sentence.split(" ");
        if(words.length==1){
            String s1 = words[0];
            if(s1.charAt(0)==s1.charAt(s1.length()-1))
                return true;
            return false;
        }
        boolean w=false;
        boolean cir = false;
        for(int i=0;i<words.length-1;i++){
            String str1=words[i];
            String str2 = words[i+1];
            if(str1.charAt(str1.length()-1) == str2.charAt(0))
                w=true;
            else
                return false;
        }
        
        String str1 = words[0];
        String str2 = words[words.length-1];
        if(str1.charAt(0)==str2.charAt(str2.length()-1))
            cir=true;
        if(cir && w)
            return true;
                                           
        return false;
    }
}
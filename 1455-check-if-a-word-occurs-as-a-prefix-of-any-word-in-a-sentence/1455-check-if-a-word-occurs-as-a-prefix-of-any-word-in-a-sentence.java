class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        ArrayList<String> hs = new ArrayList<>();
        String str="";
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            if(ch!=' '){
                str+=ch;
            }
            else{
                hs.add(str);
                str="";
            }
        }
        hs.add(str);
        ArrayList<Integer> res = new ArrayList<>();
       for(int i=0;i<hs.size();i++){
           String s = hs.get(i);
           if(s.startsWith(searchWord))
               res.add(i+1);
       }
        if(res.size()>0){
            return res.get(0); 
        }
       return -1; 
    }
}
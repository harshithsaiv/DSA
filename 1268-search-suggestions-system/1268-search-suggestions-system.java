class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        String s ="";
      List<List<String>> res = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            s+=searchWord.charAt(i);
            System.out.println(s);
            ArrayList<String> ar = new ArrayList<>();
            for(String str : products){
                if(str.startsWith(s)){
                    ar.add(str);
                }
            }
            if(ar.size()>3){
                Collections.sort(ar);
                ArrayList<String> rar = new ArrayList<>();
                rar.add(ar.get(0));
                rar.add(ar.get(1));
                rar.add(ar.get(2));
                res.add(rar);
            }
            else{
                Collections.sort(ar);
                res.add(ar);
            }
                
            
        }
        return res;
    }
}
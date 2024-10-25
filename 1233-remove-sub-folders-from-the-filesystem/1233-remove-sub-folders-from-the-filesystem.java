class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folders = new HashSet<>();
        for(String s : folder){
            folders.add(s);
        }

        ArrayList<String> result = new ArrayList<>();
        
        for(String s : folders){
            boolean isSubFolder = false;
            String prefix = s;
            while(!prefix.isEmpty()){
                int pos = prefix.lastIndexOf('/');
                if (pos == -1)
                    break;
                prefix = prefix.substring(0,pos);
                if(folders.contains(prefix)){
                    isSubFolder = true;
                    break;
                }      
            }
            if(!isSubFolder){
                result.add(s);
            }
        }
        return result;
    }
}
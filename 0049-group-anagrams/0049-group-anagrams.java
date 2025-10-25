class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String str: strs){
            String[] arr = str.split("");
            Arrays.sort(arr);
            List<String> list = hm.getOrDefault(String.join("", arr), new ArrayList<String>());
            list.add(str);
            hm.put(String.join("", arr), list);
        }
        for(List<String> list: hm.values()){
            result.add(list);
        }
        return result;
    }
}
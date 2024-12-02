class Solution {
    public int findChampion(int n, int[][] edges) {
        HashMap<Integer,Integer> indegree = new HashMap<>();
        HashMap<Integer,Integer> outdegree = new HashMap<>();
        for(int i=0;i<n;i++){
            indegree.put(i,0);
            outdegree.put(i,0);
        }
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<edges.length;i++){
            int elem = edges[i][1];
            if(indegree.containsKey(elem)){
                int val = indegree.get(elem);
                indegree.put(elem,val+1);
            }
            else{
                indegree.put(elem,1);
            }
        }
        
//         for(int i=0;i<n;i++){
//             int elem = edges[i][0];
//             if(outdegree.contiansKey(elem)){
//                 int val = outdegree.get(elem);
//                 outdegree.put(elem,val+1);
//             }
//             else{
//                 outdegree.put(elem,1);
//             }
//         }
        for(Map.Entry<Integer,Integer> elem :indegree.entrySet()){
            if(elem.getValue()==0)
                res.add(elem.getKey());
        }
        if(res.size()==1)
            return res.get(0);
        return -1;
    }
}
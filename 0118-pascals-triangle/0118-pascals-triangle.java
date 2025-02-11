class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1) return res;
        res.add(new ArrayList<>(Arrays.asList(1,1)));
        for(int i =2;i<numRows;i++){
            List<Integer> n = res.get(i-1);
            List<Integer> mid_res=new ArrayList<>();
            mid_res.add(1);
            for(int j=0;j<n.size()-1;j++){
                int sum= n.get(j)+n.get(j+1);
                mid_res.add(sum);
            }
            mid_res.add(1);
            res.add(mid_res);
        }
        return res;
    }
}
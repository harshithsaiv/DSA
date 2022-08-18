class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num:arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        ArrayList<Integer> lst = new ArrayList(map.values());
        Collections.sort(lst);
        int res = 0;
        int sum = 0;
        int index = lst.size() -1;
        while (sum < arr.length/2 && index >= 0) {
            int e = lst.get(index);
            res += 1;
            sum += e;
            index -= 1;
        }
        return res;
    }
}
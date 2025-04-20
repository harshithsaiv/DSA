class Solution {
    public String countAndSay(int n) {
        return resultcal(1,n,"1");
    }

    public String resultcal(int x , int n,String current){
        if(x==n)
            return current;
        else{
           String next = create(mapInt(current));
           return resultcal(x+1,n,next);
        }
    }
    public ArrayList<int[]> mapInt(String s) {
    ArrayList<int[]> ans = new ArrayList<>();
    if (s == null || s.length() == 0) return ans;

    int prev = s.charAt(0) - '0';
    int count = 1;

    for (int i = 1; i < s.length(); i++) {
        int curr = s.charAt(i) - '0';
        if (curr == prev) {
            count++;
        } else {
            ans.add(new int[]{prev, count});
            prev = curr;
            count = 1;
        }
    }

    // Add the last group
    ans.add(new int[]{prev, count});
    return ans;
    }

    public String create(ArrayList<int[]> a){
        StringBuilder res = new StringBuilder();
        for(int [] pairs: a){
            int val = pairs[0];
            int count = pairs[1];
            res.append(count);
            res.append(val);
        }
        return res.toString();
    }
}
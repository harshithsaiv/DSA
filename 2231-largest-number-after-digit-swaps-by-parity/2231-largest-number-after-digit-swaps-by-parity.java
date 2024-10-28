class Solution {
    public int largestInteger(int num) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        String s = Integer.toString(num);
        System.out.println(s);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int n = ch-'0';
            if(n%2==0)
                even.add(n);
            else
                odd.add(n);
        }
        Collections.sort(even,Comparator.reverseOrder());
        Collections.sort(odd,Comparator.reverseOrder());
        // for(int i:even){
        //     System.out.println(i);
        // }
        // for(int i:odd){
        //     System.out.println(i);
        // }
        int e =0;
        int o =0;
        String res="";
        for(int i=0;i<s.length();i++){
            int n = s.charAt(i);
            if(n%2==0){
                res+=even.get(e);
                e++;
            }
            else{
                res+=odd.get(o);
                o++;
            }
        }
        return Integer.valueOf(res);
    }
}
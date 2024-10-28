class Solution {
    public String toHexspeak(String num) {
        
        long n = Long.valueOf(num);
        String hex = Long.toString(n,16);
        System.out.println(hex);
        hex=hex.replaceAll("1","I");
        hex=hex.replaceAll("0","O");
        for(int i=0;i<hex.length();i++){
            char ch = hex.charAt(i);
            if(ch =='2'|| ch=='3'|| ch =='4'|| ch=='5'|| ch =='6'|| ch=='7'|| ch =='8'|| ch=='9')
                return "ERROR";
        }
        return hex.toUpperCase();
    }
}
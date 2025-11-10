class AuthenticationManager {
    private  HashMap<String,Integer> tokenMap;
    private int time;
    public AuthenticationManager(int timeToLive) {
        tokenMap = new HashMap<>();
        time=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId,currentTime+time);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId)){
             if(tokenMap.get(tokenId)>currentTime){
                tokenMap.put(tokenId,currentTime+time);
            }
        }
       
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(int val: tokenMap.values()){
            if(val>currentTime){
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
        boolean flag = true;
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(knows(i,j)==true){
                        flag=false;
                    }
                }
            }
            if(flag==true)
                res.add(i);
        }
        
        
        if(res.size()==1 ){
            boolean check = true;
            for(int i=0;i<n;i++){
            if(knows(i,res.get(0))==false)
                check=false;
            }
            if(check==true)
                return res.get(0);
        }
      return -1;
    }
}
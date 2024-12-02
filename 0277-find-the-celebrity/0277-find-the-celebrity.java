/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int numberOfPeople;
    public int findCelebrity(int n) {
        //Approach 1 : Brute Force
//         ArrayList<Integer> res = new ArrayList<>();
//         for(int i=0;i<n;i++){
//         boolean flag = true;
//             for(int j=0;j<n;j++){
//                 if(i!=j){
//                     if(knows(i,j)==true){
//                         flag=false;
//                     }
//                 }
//             }
//             if(flag==true)
//                 res.add(i);
//         }
        
        
//         if(res.size()==1 ){
//             boolean check = true;
//             for(int i=0;i<n;i++){
//             if(knows(i,res.get(0))==false)
//                 check=false;
//             }
//             if(check==true)
//                 return res.get(0);
//         }
//       return -1;
        // Approach 2 
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }
    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
}
import java.util.*;

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
       
        for (int num : arr2) {
            if (map.containsKey(num) && map.get(num) == 1) {
                map.put(num, 2);
            }
        }
        
        for (int num : arr3) {
            if (map.containsKey(num) && map.get(num) == 2) {
                res.add(num); 
            }
        }
        
        return res;
    }
}

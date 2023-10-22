import java.util.*; 
import java.util.stream.*; 
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Brute force
        ArrayList<List<Integer>> result= new ArrayList<List<Integer>>();
        ArrayList<Integer> l1 =new ArrayList<Integer>();
        ArrayList<Integer> l2= new ArrayList<Integer>();
        // for(int j : nums1)
        // {
        //     boolean flag=false;
        //     for(int i: nums2)
        //     {
        //         if(i==j)
        //         {
        //             flag=true;
        //         }
        //     }
        //     boolean flag1=false;
        //     for(int k:l1)
        //     {
        //         if(j==k)
        //         {
        //             flag1=true;
        //         }
        //     }
        //     if(flag==false && flag1==false)
        //     {
        //         l1.add(j);
        //         System.out.println(l1);
        //     }
            
        // }
        // for(int j : nums2)
        // {
        //     boolean flag=false;
        //     for(int i:nums1)
        //     {
        //         if(i==j)
        //         {
        //             flag=true;
        //         }
        //     }
        //     boolean flag1=false;
        //     for(int k:l2)
        //     {
        //         if(j==k)
        //         {
        //             flag1=true;
        //         }
        //     }
        //     if(flag==false && flag1==false)
        //     {
        //         l2.add(j);
        //         System.out.println(l2);
        //     }
        // }
        // result.add(l1);
        // result.add(l2);
        // return result;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i: nums2)
        {
            s2.add(i);
        }
        for(int i: nums1)
        {
            s1.add(i);
        }
        // Creating first array
        for(int j: s1 )
        {
            if(s2.contains(j)==false)
            {
                l1.add(j);
            }
        }    
        // creating second array
        for(int j: s2)
        {
            if(s1.contains(j)==false)
            {
                l2.add(j);
            }
        }
        result.add(l1);
        result.add(l2);
        return result;
        
    }
}
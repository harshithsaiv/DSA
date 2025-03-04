class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []nums1_copy = new int [m];
        for(int i=0;i<m;i++){
            nums1_copy[i]=nums1[i];
        }

        int p=0;
        int p1=0;
        int p2=0;

        while(p<m+n){
            if(p2 >= n || (p1 < m && nums1_copy[p1] < nums2[p2])){
                nums1[p] = nums1_copy[p1];
                p1++;
            }
            else{
                nums1[p]=nums2[p2];
                p2++;
            }
            p++;
        }

    }
}
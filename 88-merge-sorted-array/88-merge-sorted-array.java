class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length=nums1.length;
        if(m==0)
        {
           for(int i=0;i<n;i++)
           {
               nums1[i]=nums2[i];
           }
        }
        else
        {
            for(int i=0;i<n;i++,m++)
            {
                nums1[m]=nums2[i];
            }
        }
        for(int i=0;i<length-1;i++)
        {
            for(int j=0;j<length-1;j++)
            {
                if(nums1[j]>nums1[j+1])
                {
                    int temp=nums1[j];
                    nums1[j]=nums1[j+1];
                    nums1[j+1]=temp;
                }
            }
        }
    }
}
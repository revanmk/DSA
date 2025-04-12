class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(n>m)
            return findMedianSortedArrays(nums2,nums1);
        int low=0,high=n;
        // 1 2 10 11
        // low high  
        // 3 4 5 6 7 8 9 
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=((n+m+1)/2)-mid1;
            int nums1Left=(mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
            int nums1Right=(mid1==n)?Integer.MAX_VALUE:nums1[mid1];
            int nums2Left=(mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
            int nums2Right=(mid2==m)?Integer.MAX_VALUE:nums2[mid2];
            if(nums1Left<=nums2Right && nums2Left<=nums1Right){
                if ((n+m)% 2 == 0)
                return ((float)(Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right))) / 2.0;

                else
                    return Math.max(nums1Left,nums2Left);

            }
            else if(nums1Left>nums2Right)
                high=mid1-1;      
            else
                low=mid1+1;
        }
        return 0;
    }
}
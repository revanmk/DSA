class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=(int)1e6;
        int res=0;
        while(low<high){
            int mid=(low+high)/2;
            int ans=0;
            for(int i:nums)
            {
                ans+=(i+mid-1)/mid;
            }
            if(ans>threshold)
                low=mid+1;
            else
                high=mid;
        }
        return low;
    }
}
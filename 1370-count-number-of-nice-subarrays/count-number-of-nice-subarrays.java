class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       return (odd(nums,k)-odd(nums,k-1));
    }
    public static int odd(int nums[],int k)
    { 
        int l=0;
        int r=0;
        int cnt=0;
        while(r<nums.length)
        {
            if(nums[r]%2==1)
                k--;
            while(k<0){
                if(nums[l]%2==1)
                    k++;
                l++;
            }
            cnt+=r-l+1;
            r++; 
        }
        return cnt;

    }
}
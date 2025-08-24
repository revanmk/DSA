class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length-1;
        while(low<high){
            int mid = (low+high)/2;
            int num = nums[mid];
            if(num>nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
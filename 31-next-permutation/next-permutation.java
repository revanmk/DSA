class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int ind =-1;
        for(int i = len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind ==-1){
            nums = reverse(nums,0,len-1);
            return;
        }
        for(int i=len-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        nums = reverse(nums,ind+1,len-1);
    }
    public static int[] reverse(int[] nums, int start, int end){
        for(int i=start;i<=(start+end)/2;i++){
            int temp = nums[i];
            nums[i] = nums[end-(i-start)];
            nums[end-(i-start)] = temp; 
        }
        return nums;
    }
}
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int ind=-1;
        for(int i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(0,len-1,nums);
            return;
        }
        for(int i=len-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                int temp = nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
        }
        nums=reverse(ind+1,len-1,nums);
    }
    public static int[] reverse(int start, int end, int[] nums){
        while(start<end){
            int temp =  nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return nums;
    }

}
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=k%len;
        rotateArray(len-k,len-1,nums);
        rotateArray(0,len-k-1,nums);
        rotateArray(0,len-1,nums);
    } 
    int[] rotateArray(int start, int end, int[] nums){
        int len = nums.length;
        while(start<end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return nums;
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=k%len;
        rotateArray(nums,len-k,len-1);
        rotateArray(nums,0,len-k-1);
        rotateArray(nums,0,len-1);
    } 

    public void rotateArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

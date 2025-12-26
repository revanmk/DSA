class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int zeroes = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                zeroes ++;
            }
            else if(zeroes>0){
                int temp = nums[i];
                nums[i] = 0;
                nums[i-zeroes] = temp;
            }
        }
    }
}
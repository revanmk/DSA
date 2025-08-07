class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int temp=nums[0];
        int j=1;
        for(int i=1;i<len;i++){
            if(nums[i]==temp){
                continue;
            }
            else{
                temp=nums[i];
                nums[j]=temp;
                j++;
            }
        }

        return j;
    }
}
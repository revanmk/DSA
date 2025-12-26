class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int ele = nums[0];
        int count = 0;
        int j=1;
        for(int i = 1; i < len; i++){
            if(nums[i] == ele){
                continue;
            }else{
                ele = nums[i];
                nums[j]=ele;
                j++;
            }
        }
        
        return j;
    }
}
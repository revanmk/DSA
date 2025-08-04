class Solution {
    public boolean isTrionic(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int index = 0;
        while (index + 1 < len && nums[index] < nums[index + 1]) {
            index++;
        }
        if (index == 0 || index == len - 1)
             return false; 
        int peak = index;
        while (index + 1 < len && nums[index] > nums[index + 1]) {
            index++;
        }
        if (index == peak || index == len - 1) 
            return false; 

        while (index + 1 < len && nums[index] < nums[index + 1]) {
            index++;
        }

        return index == len - 1;
    }
}

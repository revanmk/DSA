class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean check=isEven(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            if(isEven(nums[i])==check)
                return false;
            check=isEven(nums[i]);
        }
        return true;
    }
    public boolean isEven(int num){
        return num%2==0;
    }
}
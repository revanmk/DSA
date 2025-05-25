class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean check=isEven(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            boolean hahaha=isEven(nums[i]);
            if(hahaha==check)
                return false;
            check=hahaha;
        }
        return true;
    }
    public boolean isEven(int num){
        return num%2==0;
    }
}
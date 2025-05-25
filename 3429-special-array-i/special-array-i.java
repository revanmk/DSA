class Solution {
    public boolean isArraySpecial(int[] nums) {
        int len=nums.length;
        if(len==1)
            return true;
        boolean check=isEven(nums[0]);
        for(int i=1;i<len;i++)
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
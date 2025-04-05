class Solution 
{
    private int sum = 0;
    public void xorsum(int[] nums,int xoro,int ind)
    {
        if(ind == nums.length)
        {
            sum+=xoro;
            return ;
        }
        xorsum(nums,xoro^nums[ind],ind+1);
        xorsum(nums,xoro,ind+1);
    }
    public int subsetXORSum(int[] nums) 
    {
        xorsum(nums,0,0);
        return sum;
    }
}
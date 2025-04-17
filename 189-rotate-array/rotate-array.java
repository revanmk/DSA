class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        rev(0,nums.length-1,nums);
        rev(0,k-1,nums);
        rev(k,nums.length-1,nums);
    }
    public int [] rev(int s,int end,int nums[])
    {
        while(s<end)
        {
            int temp=nums[s];
            nums[s]=nums[end];
            nums[end]=temp;
            s++;
            end--;
        }
        return nums;
    }
}
  
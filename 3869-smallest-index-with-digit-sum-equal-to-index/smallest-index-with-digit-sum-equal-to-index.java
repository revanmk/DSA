class Solution {
    public int smallestIndex(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++)
        {
            if(digitSum(nums[i])==i)
                return i;
        }
        return -1;
    }
    public int digitSum(int num){
        int sum=0;
        while(num>0)
        {
            sum+=(num%10);
            num=num/10;
        }
        return sum;
    }
}
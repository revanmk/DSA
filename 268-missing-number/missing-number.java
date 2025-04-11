// Optimal Solution   TC:O(n)  SC:O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length; 
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
//Brute-Force Approach   TC:O(n*n)  SC:O(1)
/*
class Solution{
    public int missingNumber(int [] nums){
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            boolean check=false;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    check=true;
                    break;
                }
            }
            if(!check)
                return i;
        }
        return n;
    }
}
*/
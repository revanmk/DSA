// Optimal Approach  TC:O(n)  SC:O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hs.contains(nums[i]))
                return true;
            else
                hs.add(nums[i]);
        }
        return false;
    }
}
// Brute-Force Approach   TC:O(nlogn)  SC:O(1)
/*
class Solution{
    public boolean containsDuplicate(int []nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                return true;
        }
        return false;
    }
}
*/
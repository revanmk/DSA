//Optimal Solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int temp=target-nums[i];
            if(hm.containsKey(temp)){
                ans[0]=i;
                ans[1]=hm.get(temp);
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return ans;
    }
}
// Brute Force
/*
class Solution{
    public int[] twoSum(int nums[],int target){
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return new int[]{};
    }
}
*/
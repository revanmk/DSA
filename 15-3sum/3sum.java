class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
         Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
             if(i>0&& nums[i]==nums[i-1])
            continue;
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                if(nums[i]+nums[left]+nums[right]==0)
                {
                     ans.add(List.of(nums[i],nums[left],nums[right]));
                while(left<right && nums[left]==nums[left+1])
                {
                    left++;
                }
                left++;
                right--;    
            }
            else if(nums[left]+nums[right]>0-nums[i])
                    right--;
            else
                    left++;           
        }
        }
        return ans;
    }
}
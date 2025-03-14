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
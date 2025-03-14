class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int max=Integer.MIN_VALUE;
        HashSet<Integer> hs=new HashSet<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
            max=Math.max(nums[i],max);
        }
        for(int i=1;i<=nums.length;i++)
        {
            if(!hs.contains(i))
                ans.add(i);
        }
        return ans;
    }
}
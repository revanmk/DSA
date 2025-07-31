class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        generateSubsets(nums,new ArrayList<>(),0);
        return ans;
    }
    public void generateSubsets(int[] nums, List<Integer> curr, int index){
        ans.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            generateSubsets(nums,curr,i+1);
            curr.remove(curr.size()-1);   
        }
    }
}
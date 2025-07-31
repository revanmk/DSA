class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0,nums,new ArrayList<>());
        return ans;
    }
    public void generateSubsets(int index,int[] nums,List<Integer> curr){
        if(index>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        generateSubsets(index+1,nums,curr);
        curr.remove(curr.size()-1);
        generateSubsets(index+1,nums,curr);
    }
}
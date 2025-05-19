class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        raparapa(new ArrayList<>(),0,n,nums);
        return ans;
    }
    public void raparapa(List<Integer> curr,int index,int n,int [] nums){
        if(index>=n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        raparapa(curr,index+1,n,nums);
        curr.remove(curr.size()-1);
        raparapa(curr,index+1,n,nums);

    }
}
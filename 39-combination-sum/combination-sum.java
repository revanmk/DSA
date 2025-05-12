class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        generate(new ArrayList<>(),candidates,target,0,0);
        return ans;
    }
    public void generate(List<Integer> temp,int[] candidates,int target,int sum,int index){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target)
            return;
        for(int i=index;i<candidates.length;i++)
        {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            generate(temp,candidates,target,sum+candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
}
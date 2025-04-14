class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        pick(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }

    public void pick(int index, int target, int candidates[], List<List<Integer>> ans, List<Integer> curr) {
        if (index == candidates.length) {
            if (target == 0)
                ans.add(new ArrayList<>(curr));
            return;
        }
        if (candidates[index] <= target) {
            curr.add(candidates[index]);
            pick(index, target - candidates[index], candidates, ans, curr);
            curr.remove(curr.size()-1);
        }
        pick(index + 1, target, candidates, ans, curr);
    }
}
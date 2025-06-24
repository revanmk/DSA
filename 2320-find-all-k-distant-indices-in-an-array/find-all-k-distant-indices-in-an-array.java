class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        HashSet<Integer> ans = new HashSet<>();
        int len = nums.length;
        List<Integer> temp = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                temp.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            for (int a : temp) {
                if (Math.abs(i-a) <= k)
                    ans.add(i);
            }
        }
        for(int i:ans)
        {
            res.add(i);
        }
        Collections.sort(res);

        return res;
    }
}
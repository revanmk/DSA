class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> allUniques = new HashSet<>();
        for (int num : nums) {
            allUniques.add(num);
        }
        int totalUnique = allUniques.size();

        int result = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> windowSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                windowSet.add(nums[j]);
                if (windowSet.size() == totalUnique) {
                    result++;
                }
            }
        }

        return result;
    }
}

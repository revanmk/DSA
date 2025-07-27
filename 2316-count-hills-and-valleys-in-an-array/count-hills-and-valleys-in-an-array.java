class Solution {
    public int countHillValley(int[] nums) {
        int len = nums.length;
        int valley = 0;
        int hill = 0;
        int prev = nums[0];
        for (int i = 1; i < len - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];
                if (curr > prev && curr > next || curr < prev && curr < next) {
                    valley++;
                    prev=curr;
                }
        }
        return valley;
    }
}
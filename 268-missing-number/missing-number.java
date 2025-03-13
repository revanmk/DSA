class Solution {
    public int missingNumber(int[] nums) {
         int n = nums.length; // Since nums contains n elements, the numbers range from 0 to n.
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
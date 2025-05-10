class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zero1 = 0, zero2 = 0;
        long sum1 = 0, sum2 = 0;

        for (int num : nums1) {
            if (num == 0) {
                zero1++;
                sum1 += 1; // minimum value we can assign
            } else {
                sum1 += num;
            }
        }

        for (int num : nums2) {
            if (num == 0) {
                zero2++;
                sum2 += 1;
            } else {
                sum2 += num;
            }
        }

        if (sum1 == sum2)
            return sum1;

        // If both arrays had 0s, it's possible to adjust
        if (zero1 > 0 && zero2 > 0)
            return Math.max(sum1, sum2);

        // If only one array has zeroes, try to adjust it
        if (zero1 > 0 && sum1 < sum2)
            return sum2;

        if (zero2 > 0 && sum2 < sum1)
            return sum1;

        return -1;
    }
}

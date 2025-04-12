import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0, right = 0;
        int nums[] = new int[nums1.length + nums2.length];
        int k = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] <= nums2[right]) {
                nums[k] = nums1[left];
                k++;
                left++;
            } else {
                nums[k] = nums2[right];
                k++;
                right++;
            }
        }
        while (left < nums1.length) {
            nums[k] = nums1[left];
            k++;
            left++;
        }
        while (right < nums2.length) {
            nums[k] = nums2[right];
            k++;
            right++;
        }
        if (nums.length % 2 == 1) {
            return nums[nums.length / 2];
        } else {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }
    }
}

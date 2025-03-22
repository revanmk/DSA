class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        // Find the first decreasing element from the end
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        // If no such element is found, reverse the entire array
        if (ind == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // Find the element just larger than nums[ind] from the end
        for (int i = nums.length - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }
        // Reverse the elements after ind
        reverse(nums, ind + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

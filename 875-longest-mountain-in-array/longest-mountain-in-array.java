class Solution {
    public int longestMountain(int[] arr) {
        int longest = 0;
        int increase = 0, decrease = 0;
        for (int i = 1; i < arr.length; i++) {
            // Reset if the sequence is interrupted
            if ((decrease != 0 && arr[i - 1] < arr[i]) || arr[i - 1] == arr[i])
                increase = decrease = 0;

            // Update increasing and decreasing sequences
            if (arr[i - 1] < arr[i])
                increase++;
            else if (arr[i - 1] > arr[i])
                decrease++;

            // Calculate mountain length if both sequences are active
            if (increase != 0 && decrease != 0)
                longest = Math.max(longest, increase + decrease + 1);
        }
        return longest;
    }
}
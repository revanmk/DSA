class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Array to store frequency of characters
        int maxFreq = 0, maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++; // Increment frequency
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // If window size - maxFreq > k, shrink window
            if ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

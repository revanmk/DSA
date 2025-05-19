class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try removing each character one by one
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            freq[i]--;  // Simulate removing one occurrence

            if (allSame(freq)) return true;

            freq[i]++;  // Restore the count
        }

        return false;
    }

    private boolean allSame(int[] freq) {
        int val = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (val == 0) val = f;
            else if (f != val) return false;
        }
        return true;
    }
}

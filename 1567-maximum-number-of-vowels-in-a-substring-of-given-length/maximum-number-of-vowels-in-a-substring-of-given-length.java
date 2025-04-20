class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int max = 0, count = 0;
        
        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        max = count;
        
        // Slide the window
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}

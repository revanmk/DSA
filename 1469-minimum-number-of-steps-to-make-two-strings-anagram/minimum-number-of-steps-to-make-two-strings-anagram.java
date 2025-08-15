class Solution {
    public int minSteps(String s, String t) {
        int ans = 0;
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();

        // Count characters in s
        for (char ch : s.toCharArray()) {
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
        }
        // Count characters in t
        for (char ch : t.toCharArray()) {
            mapt.put(ch, mapt.getOrDefault(ch, 0) + 1);
        }

        // Check all characters from both strings
        for (char ch : maps.keySet()) {
            ans += Math.abs(maps.get(ch) - mapt.getOrDefault(ch, 0));
        }
        for (char ch : mapt.keySet()) {
            if (!maps.containsKey(ch)) {
                ans += mapt.get(ch);
            }
        }

        return ans/2;
    }
}

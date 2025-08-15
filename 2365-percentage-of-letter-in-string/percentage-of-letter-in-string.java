class Solution {
    public int percentageLetter(String s, char letter) {
        int stringLength = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return !map.containsKey(letter) ? 0 : (map.get(letter) * 100) / stringLength;
    }
}
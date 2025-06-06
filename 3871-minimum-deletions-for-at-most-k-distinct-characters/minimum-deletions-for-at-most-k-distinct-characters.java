class Solution {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if (map.size() <= k) return 0;
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int count = 0;
        int dst = list.size();
        int i = 0;
        while (dst > k) {
            count += list.get(i);
            i++;
            dst--;
        }
        return count;
    }
}
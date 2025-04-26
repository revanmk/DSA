class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (List<String> current : responses) {
            Set<String> set=new HashSet<>(current);
            for (String str : set) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        
        int max = 0;
        String ans = "";
        for (String str : map.keySet()) {
            int freq = map.get(str);
            if (freq > max || (freq == max && str.compareTo(ans) < 0)) {
                max = freq;
                ans = str;
            }
        }
        return ans;
    }
}

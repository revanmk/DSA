class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            String key = a + ":" + b; // Normalize and use a string key
            
            int val = hm.getOrDefault(key, 0);
            count += val; // Each time we see the same domino again, it forms val new pairs
            hm.put(key, val + 1);
        }
        
        return count;
    }
}

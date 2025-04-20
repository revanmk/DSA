class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < answers.length; i++)
            hm.put(answers[i], hm.getOrDefault(answers[i], 0) + 1);
        int ans=0;
        for (int a : hm.keySet()) {
            int freq = hm.get(a);
            int no_groups = (int) Math.ceil((double) freq / (a + 1));
            ans += no_groups * (a + 1);

        }
        return ans;
    }
}
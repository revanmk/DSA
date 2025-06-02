class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        if (hand.length % k != 0) return false;

        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        while (!count.isEmpty()) {
            int first = count.firstKey(); // Smallest available card
            for (int i = 0; i < k; i++) {
                int current = first + i;
                if (!count.containsKey(current)) return false;
                
                count.put(current, count.get(current) - 1);
                if (count.get(current) == 0) {
                    count.remove(current);
                }
            }
        }

        return true;
    }
}

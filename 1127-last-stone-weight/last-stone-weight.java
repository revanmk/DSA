import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }
        while (heap.size() > 1) {
            int a = heap.poll(); // biggest
            int b = heap.poll(); // second biggest

            if (a != b) {
                heap.add(a - b); // push the remaining stone back
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}

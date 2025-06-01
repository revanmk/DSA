class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();  // min-heap

        for (int num : nums) {
            add(num);  // maintain only k largest elements
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();  // remove smallest to keep only k elements
        }
        return minHeap.peek();  // k-th largest
    }
}
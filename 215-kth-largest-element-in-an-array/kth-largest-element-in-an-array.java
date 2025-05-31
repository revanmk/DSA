class Solution {
    public int findKthLargest(int[] nums, int k) {
        MaxHeap heap=new MaxHeap();
        int len=nums.length;
        for(int i=0;i<len;i++)
        {
            heap.insert(nums[i]);
        }
        while(k-->1)
        {
            heap.delete();
        }
        return heap.getMax();
    }
}

class MaxHeap {
    ArrayList<Integer> heap;

    MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int x) {
        heap.add(x);
        int idx = heap.size() - 1;
        while (idx > 0 && heap.get(idx) > heap.get((idx - 1) / 2)) {
            int parentIdx = (idx - 1) / 2;
            int temp = heap.get(idx);
            heap.set(idx, heap.get(parentIdx));
            heap.set(parentIdx, temp);
            idx = parentIdx;
        }
    }

    public void delete() {
        if (heap.size() == 0) return;

        heap.set(0, heap.remove(heap.size() - 1));
        int idx = 0;
        while ((2 * idx) + 1 < heap.size()) {
            int maxIdx = idx;
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            if (left < heap.size() && heap.get(left) > heap.get(maxIdx))
                maxIdx = left;
            if (right < heap.size() && heap.get(right) > heap.get(maxIdx))
                maxIdx = right;

            if (maxIdx == idx)
                break;

            int temp = heap.get(idx);
            heap.set(idx, heap.get(maxIdx));
            heap.set(maxIdx, temp);
            idx = maxIdx;
        }
    }

    public int getMax() {
        if (heap.isEmpty()) return -1; 
        return heap.get(0);
    }
}

class Solution {
    public static Deque<Integer> dq;

    public int[] maxSlidingWindow(int[] nums, int k) {
        dq = new ArrayDeque<>();
        int len = nums.length;
        int ans[] = new int[len - k + 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if(!dq.isEmpty() && dq.getFirst() <= i-k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                ans[index++] = nums[dq.getFirst()];
            }
        }
        return ans;
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<len;i++){
            pq.add(nums[i]);
        }
        int ans = 0;

        for(int i=0;i<=(len-k);i++){
            ans = pq.poll();
        }
        return ans;
    }
}

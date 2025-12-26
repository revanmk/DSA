class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<len;i++){
            pq.add(nums[i]);
        }
        int ans = 0;
        while(k-->0){
            ans = pq.poll();
        }
        return ans;
    }
}


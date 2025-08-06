class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int ele:arr){
            pq.add(ele);
        }
        while(k-->0){
            ans.add(pq.poll());
        }
        return ans;
    }
}

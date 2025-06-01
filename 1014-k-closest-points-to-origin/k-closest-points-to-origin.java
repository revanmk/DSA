class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(
            (a,b)->Integer.compare(
                a[0]*a[0]+a[1]*a[1],
                b[0]*b[0]+b[1]*b[1]
                )
            );
        int ans[][]=new int[k][2];
        for(int[] temp:points){
            minHeap.add(temp);
        }
        for(int i=0;i<k;i++)
        {
            ans[i]=(minHeap.poll());
        }
        return ans;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dis = new int[heights.length][heights[0].length];
        for(int i=0;i<dis.length;i++){
            for(int j=0;j<dis[0].length;j++){
                dis[i][j]=10000000;
            }
        }
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)->a.d-b.d);
        dis[0][0]=0;
        pq.add(new Triple(0,0,0));
        int dr[]=new int[]{-1,0,1,0};
        int dc[]=new int[]{0,1,0,-1};
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            int dist = t.d;
            int a = t.i;
            int b = t.j;
            if(a==heights.length-1 && b==heights[0].length-1){
                return dist;
            }
            for(int i=0;i<4;i++){
                int newr = a+dr[i];
                int newc = b+dc[i];
                if(newr>=0 && newr<heights.length && newc>=0 && newc<heights[0].length){
                    int newEffort = Math.max(dist,Math.abs(heights[newr][newc]-heights[a][b]));
                    if(newEffort<dis[newr][newc]){
                        dis[newr][newc]=newEffort;
                        pq.add(new Triple(newEffort,newr,newc));
                    }
                }
            }
        }
        return 0;

    }
}
class Triple{
    int d;
    int i;
    int j;
    Triple(int d, int i, int j){
        this.d=d;
        this.i=i;
        this.j=j;
    }
}
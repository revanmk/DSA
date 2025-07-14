class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[]=new boolean[isConnected.length];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(!vis[i]){
                bfs(isConnected,i,vis);
                cnt++;
            }
        }
        return cnt;
    }
    public void bfs(int[][] graph,int index,boolean[]check){
        Queue<Integer> q =new LinkedList<>();
        q.offer(index);
        check[index]=true;
        while(!q.isEmpty()){
            int a=q.poll();
            for(int i=0;i<graph.length;i++)
            {
                if(graph[a][i]==1 && !check[i]){
                    q.add(i);
                    check[i]=true;
                }
            }
        }
    }
}
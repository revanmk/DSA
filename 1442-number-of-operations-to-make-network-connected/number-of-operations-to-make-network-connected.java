class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> g = new ArrayList<>();
        if(connections.length<n-1){
            return -1;
        }
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] temp : connections){
            g.get(temp[0]).add(temp[1]);
            g.get(temp[1]).add(temp[0]);
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(g,vis,i);
                ans++;
            }
        }
        return ans-1;
    }
    public static void dfs(List<List<Integer>> g, boolean[] vis, int src){
        vis[src]=true;
        for(int i : g.get(src)){
            if(!vis[i]){
                dfs(g,vis,i);
            }
        }
    }
}
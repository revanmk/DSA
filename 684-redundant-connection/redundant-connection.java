class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            g.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            boolean visit[] = new boolean[edges.length+1];
            g.get(a).add(b);
            g.get(b).add(a);
            if(dfs(a,-1,g,visit)){
                return edge;
            }
        }
        return new int[0];
    }
    public static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit){
        if(visit[node]){
            return true;
        }
        visit[node]=true;
        for(int nei : adj.get(node)){
            if(nei==parent){
                continue;
            }
            if(dfs(nei,node,adj,visit)){
                return true;
            }
        }
        return false;
    }
}
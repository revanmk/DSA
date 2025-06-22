class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
    boolean visited[] = new boolean[adj.size()];
        dfs(0,visited,adj);
        return list;
    }
    public void dfs(int node,boolean visited[],ArrayList<ArrayList<Integer>> adj){
        if(node==adj.size()){
            return;
        }
        visited[node]=true;
        list.add(node);
        for(int a:adj.get(node)){
            if(!visited[a])
            dfs(a,visited,adj);
        }
    }
}
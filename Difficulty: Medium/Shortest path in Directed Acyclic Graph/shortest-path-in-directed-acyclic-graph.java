// User function Template for Java
class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> g = new ArrayList<>();
        for(int i=0;i<V;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            g.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        int vis[]=new int[V];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                toposort(i,g,vis,st);
            }
        }
        int dist[] = new int[V];
        Arrays.fill(dist,1000000000);
        dist[0]=0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(int i=0;i<g.get(node).size();i++){
                int v = g.get(node).get(i).node;
                int w = g.get(node).get(i).wt;
                if(dist[node]+w<dist[v]){
                    dist[v]=dist[node]+w;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==1000000000){
                dist[i]=-1;
            }
        }
        return dist;
    }
    public void toposort(int n, List<List<Pair>> g, int[] vis, Stack<Integer> st){
        vis[n]=1;
        for(int i=0;i<g.get(n).size();i++){
            int v = g.get(n).get(i).node;
            if(vis[v]==0){
                toposort(v,g,vis,st);
            }
        }
        st.push(n);
    }
}
class Pair{
    int node;
    int wt;
    Pair(int node, int wt){
        this.node=node;
        this.wt=wt;
    }
}

class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] shortestPath = new int[adj.size()];
        Arrays.fill(shortestPath,Integer.MAX_VALUE);
        shortestPath[src]=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int a:adj.get(node)){
                if(shortestPath[node]+1<shortestPath[a]){
                    shortestPath[a]=shortestPath[node]+1;
                    q.add(a);
                }
            }
        }
        for(int i=0;i<shortestPath.length;i++){
            if(shortestPath[i]==Integer.MAX_VALUE){
                shortestPath[i]=-1;
            }
        }
        return shortestPath;
    }
}

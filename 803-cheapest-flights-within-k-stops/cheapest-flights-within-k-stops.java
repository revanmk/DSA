class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        int nodes = n;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            graph.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Triplet> pq = new LinkedList<>();
        int minCost[] = new int[n];
        Arrays.fill(minCost,1000000);
        minCost[src]=0;
        pq.offer(new Triplet(src,0,0));
        while(!pq.isEmpty()){
            Triplet t = pq.poll();
            int node = t.node;
            int cost = t.cost;
            int stops = t.stops;
            if(stops>k){
                continue;
            }
            for(Pair p : graph.get(node)){
                if(cost+p.w<minCost[p.v]){
                    minCost[p.v]=cost+p.w;
                    pq.offer(new Triplet(p.v,cost+p.w,stops+1));
                }
            }
        }
        return minCost[dst] == 1000000 ? -1 : minCost[dst];
    }
}
class Pair{
    int v;
    int w;
    Pair(int v, int w){
        this.v=v;
        this.w=w;
    }
}

class Triplet {
    int node, cost, stops;
    Triplet(int node, int cost, int stops) {
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}
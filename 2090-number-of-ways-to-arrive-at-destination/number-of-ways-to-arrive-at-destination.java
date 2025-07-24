class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            g.get(road[0]).add(new Pair(road[1], road[2]));
            g.get(road[1]).add(new Pair(road[0], road[2]));
        }
        long dist[] = new long[n];
        int ways[] = new int[n];
        int mod = (int) (1e9 + 7);
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.wt, b.wt));  // ✅
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.wt > dist[p.node]) {
                continue;
            }
            for (Pair temp : g.get(p.node)) {
                int node = temp.node;
                long wt = temp.wt;

                if (p.wt + wt < dist[node]) {
                    dist[node] = p.wt + wt;
                    ways[node] = ways[p.node];
                    pq.offer(new Pair(node, dist[node]));
                }
                else if (p.wt + wt == dist[node]) {
                    ways[node] = (ways[node] + ways[p.node]) % mod;
                }
            }
        }
        return ways[n - 1] ;
    }
}

class Pair {
    int node;
    long wt;

    Pair(int node, long wt) {
        this.node = node;
        this.wt = wt;
    }
}
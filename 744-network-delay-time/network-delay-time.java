class Solution {
    public int networkDelayTime(int[][] times, int nodes, int k) {
        List<List<Pair>> g = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int n = times[i][0];
            int m = times[i][1];
            int w = times[i][2];
            g.get(n).add(new Pair(m, w));
        }
        int[] dist = new int[nodes + 1];
        Arrays.fill(dist, 1000000);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int temp = current.node;
            int weight = current.wt;
            if (weight > dist[temp]) {
                continue;
            }
            for (Pair p : g.get(temp)) {
                int node = p.node;
                int wt = p.wt;
                if (dist[temp] + wt < dist[node]) {
                    dist[node] = dist[temp] + wt;
                    pq.offer(new Pair(node, dist[node]));
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= nodes; i++) {
            if (dist[i] == 1000000)
                return -1; // node is unreachable
            ans = Math.max(ans, dist[i]);
        }
        return ans;

    }
}

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}
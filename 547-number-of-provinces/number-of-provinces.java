class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(isConnected, i, vis);
                ans++;
            }
        }
        return ans;
    }

    public void bfs(int[][] adj, int start, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < adj.length; i++) {
                if (adj[node][i] == 1 && !vis[i]) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }
}

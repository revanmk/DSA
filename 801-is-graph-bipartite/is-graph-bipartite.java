class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int color[] = new int[nodes];
        Arrays.fill(color, -1);
        for (int i = 0; i < nodes; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color))
                    return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int n : graph[t]) {
                if (color[n] == -1) {
                    color[n] = 1-color[t];
                    q.add(n);
                }
                if (color[n] == color[t])
                    return false;
            }
        }
        return true;

    }
}
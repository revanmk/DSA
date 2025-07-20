class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        List<List<Integer>> g = new ArrayList<>();
        int nodes = graph.length;
        for (int i = 0; i < nodes; i++) {
            g.add(new ArrayList<>());
        }
        int indegree[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            indegree[i] = graph[i].length;
            for (int u : graph[i]) {
                g.get(u).add(i);
            }
        }
        for (int i = 0; i < nodes; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        boolean[] safe = new boolean[nodes];
        while (!q.isEmpty()) {
            int temp = q.poll();
            safe[temp] = true;
            for (int a : g.get(temp)) {
                indegree[a]--;
                if (indegree[a] == 0) {
                    q.offer(a);
                }
            }
        }
        for (int i = 0; i < nodes; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
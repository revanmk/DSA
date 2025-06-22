class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int completeCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                int[] componentInfo = new int[2]; // [0] = number of nodes, [1] = sum of degrees
                dfs(i, graph, visited, componentInfo);

                int nodes = componentInfo[0];
                int edgesInComponent = componentInfo[1] / 2; // Each edge counted twice

                if (edgesInComponent == nodes * (nodes - 1) / 2) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }

    public void dfs(int node, List<Integer>[] graph, Set<Integer> visited, int[] componentInfo) {
        visited.add(node);
        componentInfo[0]++; // count nodes
        componentInfo[1] += graph[node].size(); // sum of degrees

        for (int neighbor : graph[node]) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, componentInfo);
            }
        }
    }
}

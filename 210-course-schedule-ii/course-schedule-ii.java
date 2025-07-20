class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[numCourses];
        int ans[] = new int[numCourses];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        if (isPossible(numCourses, q, indegree, adj, ans))
            return ans;
        return new int[0];
    }

    boolean isPossible(int numCourses, PriorityQueue<Integer> q, int indegree[], List<List<Integer>> adj, int ans[]) {
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int c = 0;
        while (!q.isEmpty()) {
            int a = q.poll();
            ans[c] = a;
            c++;
            for (int temp : adj.get(a)) {
                indegree[temp]--;
                if (indegree[temp] == 0) {
                    q.offer(temp);
                }
            }
        }
        return c == numCourses;
    }
}
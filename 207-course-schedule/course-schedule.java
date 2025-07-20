class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[numCourses];
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
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int c=0;
        while (!q.isEmpty()) {
            int a = q.poll();
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
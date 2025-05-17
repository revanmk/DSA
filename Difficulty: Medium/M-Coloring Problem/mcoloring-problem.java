//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                edgeList.add(new int[] {u, v});
                edgeList.add(new int[] {v, u});
            }

            int[][] edges = new int[edgeList.size()][2];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int m = Integer.parseInt(sc.nextLine().trim());

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(V, edges, m) ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        int n=edges.length;
        int color[]=new int[v];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v1=edge[1];
            adj.get(u).add(v1);
            adj.get(v1).add(u);
        }
        return color(0,adj,color,v,m);
    }
    boolean color(int node,ArrayList<ArrayList<Integer>> edges,int[] color,int v,int m){
        if(node==v)
            return true;
        for(int i=1;i<=m;i++)
        {
            if(isSafe(node,edges,color,i)){
                color[node]=i;
                if(color(node+1,edges,color,v,m))
                    return true;
                color[node]=0;
            }
        }
        return false;
    }
    boolean isSafe(int node,ArrayList<ArrayList<Integer>> edges,int[] color, int col){
        for(int it:edges.get(node)){
            if(color[it]==col)
                return false;
        }
        return true;
    }
}
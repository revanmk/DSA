//{ Driver Code Starts
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] maze = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }

            if (sc.hasNextLine()) sc.nextLine();

            Solution obj = new Solution();
            ArrayList<String> result = obj.ratInMaze(maze);

            if (result.isEmpty()) {
                System.out.print("[]");
            } else {
                for (String path : result) {
                    System.out.print(path + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans=new ArrayList<>();
        int n=maze.length;
        int vis[][]=new int[n][n];
        if(maze[0][0]==1)
            check(0,0,n,vis,maze,"",ans);
        return ans;
    }
    public void check(int i,int j,int n,int[][] vis,int[][] maze,String move, ArrayList<String>  ans){
        if(i==n-1 && j==n-1){
            ans.add(move);
            return;
        }
        
        if(i+1<n && maze[i+1][j]==1 && vis[i+1][j]==0){
            vis[i][j]=1;
            check(i+1,j,n,vis,maze,move+"D",ans);
            vis[i][j]=0;
        }
        if(j-1>=0 && maze[i][j-1]==1 && vis[i][j-1]==0){
            vis[i][j]=1;
            check(i,j-1,n,vis,maze,move+"L",ans);
            vis[i][j]=0;
        }
        if(j+1<n && maze[i][j+1]==1 && vis[i][j+1]==0){
            vis[i][j]=1;
            check(i,j+1,n,vis,maze,move+"R",ans);
            vis[i][j]=0;
        }
        if(i-1>=0 && maze[i-1][j]==1 && vis[i-1][j]==0){
            vis[i][j]=1;
            check(i-1,j,n,vis,maze,move+"U",ans);
            vis[i][j]=0;
        }
        
    }
}
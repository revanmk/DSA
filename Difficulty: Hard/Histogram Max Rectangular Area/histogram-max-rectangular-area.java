//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int getMaxArea(int arr[]) {
        int[] previous=new int[arr.length];
        int[] nextious=new int [arr.length];
        previous=prevMax(arr);
        nextious=nextMax(arr);
        int maxArea=0;
        for(int i=0;i<arr.length;i++)
        {
            maxArea=Math.max(maxArea,(arr[i]*(nextious[i]-previous[i]-1)));
        }
        return maxArea;
    }
    public static int[] prevMax(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int prev[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            prev[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return prev;
    }
    public static int[] nextMax(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int next[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            next[i]=(st.isEmpty())?arr.length:st.peek();
            st.push(i);
        }
        return next;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
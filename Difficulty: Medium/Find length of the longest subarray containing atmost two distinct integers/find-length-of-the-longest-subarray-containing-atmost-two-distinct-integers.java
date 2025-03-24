//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalElements(Integer[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int left=0,maxLength=0;
        for(int right=0;right<arr.length;right++)
        {
           hm.put(arr[right],hm.getOrDefault(arr[right],0)+1);
           while(hm.size()>2)
           {
               hm.put(arr[left],hm.get(arr[left])-1);
               if(hm.get(arr[left])==0)
                    hm.remove(arr[left]);
                left++;
           }
           maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
        
    }
}

// [3, 1, 2, 2, 2, 2]

// [1,1,1,2,3,4]
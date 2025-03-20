//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        int buy1=Integer.MAX_VALUE,buy2=Integer.MAX_VALUE;
        int profit1=0,profit2=0;
        for(int i=0;i<prices.length;i++)
        {
            buy1=Math.min(buy1,prices[i]);
            profit1=Math.max(profit1,prices[i]-buy1);
            buy2=Math.min(buy2,prices[i]-profit1);
            profit2=Math.max(profit2,prices[i]-buy2);
        }
        return profit2;
        
    }
}

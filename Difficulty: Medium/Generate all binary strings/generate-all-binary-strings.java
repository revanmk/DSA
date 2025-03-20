//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    List<String> ans=new ArrayList<>();
    backtrack(n,new StringBuilder(),ans);
    return ans;
  }
  static void backtrack(int n, StringBuilder current,List<String> ans){
     if(current.length()==n)
     {
         ans.add(current.toString());
         return;
     }
     current.append('0');
     backtrack(n,current,ans);
     current.deleteCharAt(current.length()-1);
     if(current.length()==0 || current.charAt(current.length()-1)!='1'){
         current.append('1');
         backtrack(n,current,ans);
         current.deleteCharAt(current.length()-1);
     }
  }
}
     
     
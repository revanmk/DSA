//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GfG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Solution{
    
    // Recursive function with memoization to count distinct subsequences
    private static int countDistinctSubseq(String s, int index, HashMap<Integer, Integer> memo, HashMap<Character, Integer> lastSeen) {
        if (index == 0) return 1; // Base case: empty string has one subsequence ""

        if (memo.containsKey(index)) return memo.get(index);

        // Case 1: Include current character
        int result = 2 * countDistinctSubseq(s, index - 1, memo, lastSeen);

        // Case 2: Remove overcounted subsequences due to duplicate characters
        char currentChar = s.charAt(index - 1);
        if (lastSeen.containsKey(currentChar)) {
            int lastIndex = lastSeen.get(currentChar);
            result -= countDistinctSubseq(s, lastIndex - 1, memo, lastSeen);
        }

        // Store result in memoization table
        memo.put(index, result);
        // Update last occurrence of the character
        lastSeen.put(currentChar, index);

        return result;
    }

    public static String betterString(String s1, String s2) {
        HashMap<Integer, Integer> memo1 = new HashMap<>();
        HashMap<Integer, Integer> memo2 = new HashMap<>();
        HashMap<Character, Integer> lastSeen1 = new HashMap<>();
        HashMap<Character, Integer> lastSeen2 = new HashMap<>();

        int count1 = countDistinctSubseq(s1, s1.length(), memo1, lastSeen1);
        int count2 = countDistinctSubseq(s2, s2.length(), memo2, lastSeen2);

        return (count1 >= count2) ? s1 : s2;
    }

    public static void main(String[] args) {
        String s1 = "gfg";
        String s2 = "ggg";
        System.out.println(betterString(s1, s2)); // Output: "gfg"
    }
}

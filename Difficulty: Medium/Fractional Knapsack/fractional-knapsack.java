//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();

        // Create an array of items with value, weight, and value-to-weight ratio
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val.get(i), wt.get(i));
        }

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxValue = 0.0;
        
        for (int i = 0; i < n && capacity > 0; i++) {
            if (capacity >= items[i].weight) {
                // Take the full item
                maxValue += items[i].value;
                capacity -= items[i].weight;
            } else {
                // Take the fractional part
                maxValue += items[i].ratio * capacity;
                capacity = 0; // Knapsack is full
            }
        }
        return maxValue;
    }
}

// Helper class to store item information
class Item {
    int value, weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}
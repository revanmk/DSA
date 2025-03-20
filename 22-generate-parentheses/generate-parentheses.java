class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, 0, 0, ans, new StringBuilder());
        return ans;
    }

    public static void generate(int n, int open, int close, List<String> ans, StringBuilder current) {
        // Base case: If we have placed all 2 * n parentheses, add to the result
        if (current.length() == 2 * n) {
            ans.add(current.toString());
            return;
        }

        // Add '(' if we still have remaining open parentheses
        if (open < n) {
            current.append("(");
            generate(n, open + 1, close, ans, current);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Add ')' only if it does not exceed the number of open '('
        if (close < open) {
            current.append(")");
            generate(n, open, close + 1, ans, current);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}

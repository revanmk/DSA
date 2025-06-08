class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        Node root = new Node();

        // Insert all numbers into trie in reverse (for easier traversal)
        for (int i = 1; i <= n; i++) {
            Node node = root;
            Stack<Integer> digits = new Stack<>();
            int num = i;
            while (num > 0) {
                digits.push(num % 10);
                num /= 10;
            }
            while (!digits.isEmpty()) {
                int d = digits.pop();
                if (!node.contains(d)) {
                    node.insert(d, new Node());
                }
                node = node.get(d);
            }
            node.setEnd(i);
        }

        dfs(root, ans);
        return ans;
    }

    private void dfs(Node node, List<Integer> ans) {
        if (node == null) return;
        if (node.isEnd()) {
            ans.add(node.getValue());
        }
        for (int i = 0; i <= 9; i++) {
            dfs(node.links[i], ans);
        }
    }
}

class Node {
    Node[] links = new Node[10];
    Integer val = null;

    void insert(int i, Node node) {
        links[i] = node;
    }

    Node get(int i) {
        return links[i];
    }

    boolean contains(int i) {
        return links[i] != null;
    }

    void setEnd(int value) {
        val = value;
    }

    boolean isEnd() {
        return val != null;
    }

    int getValue() {
        return val;
    }
}

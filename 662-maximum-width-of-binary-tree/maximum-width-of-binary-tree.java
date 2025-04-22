class Pair {
    int index;
    TreeNode node;
    Pair(TreeNode a, int val) {
        node = a;
        index = val;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // Offset for normalization
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index - minIndex; // Normalize index

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    queue.offer(new Pair(node.left, 2 * index + 1));
                if (node.right != null)
                    queue.offer(new Pair(node.right, 2 * index + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}

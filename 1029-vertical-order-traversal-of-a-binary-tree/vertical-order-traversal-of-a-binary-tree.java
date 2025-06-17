class Solution {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> vertical : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : vertical.values()) {
                while (!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }
            result.add(col);
        }

        return result;
    }

    public void dfs(TreeNode root, int hd,int vd) {
        if (root == null) return;

       if(!map.containsKey(hd)){
        map.put(hd,new TreeMap<>());
       }
       if(!map.get(hd).containsKey(vd)){
        map.get(hd).put(vd, new PriorityQueue<>());
       }
       map.get(hd).get(vd).add(root.val);
        dfs(root.left, hd - 1,vd+1);
        dfs(root.right, hd + 1,vd+1);
    }
}

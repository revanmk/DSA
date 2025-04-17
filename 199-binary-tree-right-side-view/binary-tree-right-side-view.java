/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        res=bfs(root);
        for(List<Integer> temp:res){
            r.add(temp.get(temp.size()-1));
        }
        return r;
    }
    public List<List<Integer>> bfs(TreeNode root)
    {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                TreeNode current=q.poll();
                level.add(current.val);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
            boolean leftToRight=false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> level=new ArrayList<>();
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                TreeNode n=q.poll();
                level.add(n.val);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            if(leftToRight)
            {
                Collections.reverse(level);
            }
            leftToRight=!leftToRight;
            result.add(level);
            }
            return result;
    }
}
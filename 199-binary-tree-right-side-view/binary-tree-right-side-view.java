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
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
            return ans;
        q.add(root);
        while(!q.isEmpty()){
            int len=q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<len;i++)
            {
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            list.add(temp);
        }
        for(ArrayList<Integer> temp:list){
            ans.add(temp.get(temp.size()-1));
        }
        return ans;
    }
}
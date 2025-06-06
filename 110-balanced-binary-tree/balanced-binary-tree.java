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
    public boolean isBalanced(TreeNode root) {
        boolean check=false;
        if(root==null)
            return true;
        if(Math.abs(height(root.left)-height(root.right))<=1)
            check=isBalanced(root.left)&&isBalanced(root.right);
        return check;
        
    }
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}
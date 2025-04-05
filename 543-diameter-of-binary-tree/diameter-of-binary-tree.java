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
    int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
        return result;
    }
     public int maxDepth(TreeNode root) {
        if(root==null)
            return -1;
        int left=maxDepth(root.left)+1;
        int right=maxDepth(root.right)+1;
        result=Math.max(left+right,result);
        return Math.max(left,right);
    }
}
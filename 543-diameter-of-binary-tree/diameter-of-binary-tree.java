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
    int depth=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return depth;
    }
    public int maxDepth(TreeNode root){
        if(root==null)
            return -1;
        int a=maxDepth(root.left)+1;
        int b=maxDepth(root.right)+1;
        depth=Math.max(depth,a+b);
        return Math.max(a,b);
    }
}
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isTrue(root.left,root.right);
    }
    public boolean isTrue(TreeNode a,TreeNode b){
        if(a==null && b==null)
            return true;
        if(a==null||b==null)
            return false;
        return (a.val==b.val) && isTrue(a.left,b.right) && isTrue(b.left,a.right);
    }
}
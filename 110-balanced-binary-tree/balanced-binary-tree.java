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
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left)+1,height(root.right)+1);
    }
}
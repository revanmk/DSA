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
    public TreeNode invertTree(TreeNode temp) {
        if(temp==null){
            return temp;
        }
        TreeNode root=new TreeNode(temp.val);
        root.left=invertTree(temp.right);
        root.right=invertTree(temp.left);
        return root;
    }
}
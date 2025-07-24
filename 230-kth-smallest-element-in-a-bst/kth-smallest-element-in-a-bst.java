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
    public int kthSmallest(TreeNode root, int k) {
       return preOrder(root,k);
    }
    int ans=0;
    int i=0;
    public int preOrder(TreeNode root,int k)
    {
        if(root==null)
            return 0;
        preOrder(root.left,k);
        i++;
        if(i==k){
            ans=root.val;
            return ans;
        }
        preOrder(root.right,k);
        return ans;
    }
}
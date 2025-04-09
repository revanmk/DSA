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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public int maxPathSum(TreeNode root) {
        int ans[]=new int[1];
        ans[0]=root.val;
        maxi(root,ans);
        return ans[0];

    }
    static int maxi(TreeNode root,int[] ans){
        if(root==null)
            return 0;
        int l=Math.max(0,maxi(root.left,ans));
        int r=Math.max(0,maxi(root.right,ans));
        ans[0]=Math.max(ans[0],l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}
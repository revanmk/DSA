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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inorderLength = inorder.length;
        int preorderLength = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorderLength; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, inorderLength-1, 0, preorder, preorderLength-1, 0, map);
        return root;
    }

    public static TreeNode buildTree(int[] inorder, int inorderLength, int starti, int[] preorder, int preorderLength, int startp, HashMap<Integer,Integer> map) {
        if(starti>inorderLength || startp>preorderLength){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startp]);
        int root_index = map.get(root.val);
        int numsLeft = root_index-starti;
        root.left=buildTree(inorder,root_index-1,starti,preorder,startp+numsLeft,startp+1,map);
        root.right=buildTree(inorder,inorderLength,root_index+1,preorder,preorderLength,startp+numsLeft+1,map);
        return root;
    }
}
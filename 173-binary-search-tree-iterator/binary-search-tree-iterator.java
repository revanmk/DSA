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
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack();
        pushIntoStack(root,st);
    }
    
    public int next() {
       TreeNode a =st.pop();
       pushIntoStack(a.right,st);
       return a.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void pushIntoStack(TreeNode temp,Stack st){
        while(temp!=null){
            st.push(temp);
            temp=temp.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
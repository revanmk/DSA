/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        getParents(root);
        HashMap<TreeNode,Boolean> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        map.put(target,true);
        int curr=0;
        while(!q.isEmpty()){
            int len=q.size();
            if(curr==k){
                break;
            }
            curr++;
            for(int i=0;i<len;i++)
            {
                TreeNode node=q.poll();
                if(node.left!=null && map.get(node.left)==null){
                    q.add(node.left);
                    map.put(node,true);
                }
                if(node.right!=null && map.get(node.right)==null){
                    q.add(node.right);
                    map.put(node,true);
                }
                if(parent.get(node)!=null && map.get(parent.get(node))==null){
                    q.add(parent.get(node));
                    map.put(parent.get(node),true);
                }
            }
        }
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            ans.add(node.val);
        }
        return ans;
    }
    public void getParents(TreeNode node){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int len=q.size();
            TreeNode root=q.poll();
            if(root.left!=null){
                parent.put(root.left,root);
                q.add(root.left);
            }
            if(root.right!=null){
                parent.put(root.right,root);
                q.add(root.right);
            }
        }
    }
}
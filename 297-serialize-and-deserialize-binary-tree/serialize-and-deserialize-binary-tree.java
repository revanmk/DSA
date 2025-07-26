/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string
    public String serialize(TreeNode root) {
        if(root==null){
            return "N ";
        }
        String val=String.valueOf(root.val);
        return val+" "+serialize(root.left)+serialize(root.right);
    }
    private int index;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] lt = data.split(" ");
        index = 0;
        TreeNode root=insert(lt);
        return root;
    }
    public TreeNode insert(String[] data){
        if(data[index].equals("N")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
        index++;
        root.left=insert(data);
        root.right=insert(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
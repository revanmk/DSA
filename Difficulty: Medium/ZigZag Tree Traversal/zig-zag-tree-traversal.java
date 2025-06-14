/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG {
    ArrayList<Integer> list=new ArrayList<>();
    ArrayList<Integer> zigZagTraversal(Node root) {
        traversal(root);
        return list;
    }
    public void traversal(Node root){
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int len=q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<len;i++){
                Node node=q.poll();
                temp.add(node.data);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            if(flag){
                Collections.reverse(temp);
            }
            for(int i=0;i<temp.size();i++){
                list.add(temp.get(i));
            }
            flag=!flag;
        }
    }
}
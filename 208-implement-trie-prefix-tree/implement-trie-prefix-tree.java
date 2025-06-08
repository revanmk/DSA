class Trie {
    private Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.contains(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.contains(word.charAt(i)))
                return false;
            node=node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.contains(word.charAt(i)))
                return false;
            node=node.get(word.charAt(i));
        }
        return true;
    }
}

class Node{
    Node links[]=new Node[26];
    boolean flag=false;

    boolean contains(char ch){
        return (links[ch-'a']!=null);
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch,Node node){
        links[ch-'a']=node;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
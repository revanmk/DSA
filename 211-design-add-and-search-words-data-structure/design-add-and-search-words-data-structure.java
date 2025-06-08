class WordDictionary {
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.contains(word.charAt(i))){
                node.insert(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
     public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, Node node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null && searchInNode(word, index + 1, node.links[i])) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.contains(ch)) return false;
            return searchInNode(word, index + 1, node.get(ch));
        }
    }
}

class Node{
    Node links[]=new Node[26];
    boolean flag=false;

    public void insert(char ch,Node node){
        links[ch-'a']=node;
    }
    public boolean contains(char ch){
        return (links[ch-'a']!=null);
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void setEnd(){
        flag=true;
    }
    public boolean isEnd(){
        return flag;
    }
}




/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
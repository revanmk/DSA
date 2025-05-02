class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val=val;
            next=prev=null;
        }
    }
    Node head;
    int size;
    public MyLinkedList() {
        head=null;
        size=0;
    }
    
    public int get(int index) {
        Node temp=head;
        if(index>=size|| index<0)
            return -1;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode =new Node(val);
        if(head==null){
            head=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        if(head==null)
            head=newNode;
        else{
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        newNode.prev=temp;
        temp.next=newNode;
        }
        size++;
    }
    
  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) return;

    if (index == 0) {
        addAtHead(val);
        return;
    }
    if (index == size) {
        addAtTail(val);
        return;
    }

    Node temp = head;
    for (int i = 0; i < index; i++) {
        temp = temp.next;
    }

    Node newNode = new Node(val);
    newNode.prev = temp.prev;
    newNode.next = temp;
    if (temp.prev != null) temp.prev.next = newNode; // avoid NPE
    temp.prev = newNode;
    size++;
}

    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size)
            return;
        if(index==0){
            head=head.next;
            if(head!=null)
                head.prev=null;
            size--;
            return;
        }
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        if(temp.prev!=null)
            temp.prev.next=temp.next;
        if(temp.next!=null)
            temp.next.prev=temp.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
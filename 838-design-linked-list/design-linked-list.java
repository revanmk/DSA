class MyLinkedList {
    Node head;
    int length;

    public MyLinkedList() {
        head = null;
        length = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= length) return -1;
        Node t = head;
        for(int i = 0; i < index; i++) {
            t = t.next;
        }
        return t.data;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = newNode;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > length) return;

        if(index == 0){
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length) return;

        if(index == 0){
            head = head.next;
        } else {
            Node temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        length--;
    }
}

class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

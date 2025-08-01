class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    void push(int x) {
        arr[rear]=x;
        rear++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(front==rear){
            return -1;
        }
        return arr[front++];
    }
}
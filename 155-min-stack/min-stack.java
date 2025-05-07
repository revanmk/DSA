class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
            st.push(new Pair(val,val));
        else{
        int a=st.peek().val;
        a=Math.min(a,val);
        st.push(new Pair(val,a));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().data;
    }
    
    public int getMin() {
        return st.peek().val;
    }
}
class Pair{
    int data;
    int val;
    Pair(int data,int val){
        this.data=data;
        this.val=val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
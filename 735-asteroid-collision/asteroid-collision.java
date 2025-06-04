class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int len=arr.length;
        for(int i=0;i<len;i++){
            if(arr[i]>0){
                st.push(arr[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 &&st.peek()<-arr[i])
                    st.pop();
                if(st.isEmpty() || st.peek()<0)
                    st.push(arr[i]);
                if(st.peek()==-arr[i])
                    st.pop();
            }
        }
        int[] res = new int[st.size()];
        int i = st.size() - 1;

        while(!st.isEmpty()) {
            res[i--] = st.pop();
        }
        return res;
    }
}
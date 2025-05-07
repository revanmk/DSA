class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
                st.push(i);
            else{
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                ans=Math.max(ans,i-st.peek());
            }
        }
        return ans;
    }
}
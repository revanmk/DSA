class Solution {
    private List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(),0,0,n);
        return ans;
    }
    public void generate(StringBuilder st,int open,int close,int n){
        if(st.length()==2*n)
        {
           ans.add(st.toString()); 
        }
        if(open<n)
        {
            st.append("(");
            generate(st,open+1,close,n);
            st.deleteCharAt(st.length()-1);
        }
        if(close<open){
            st.append(")");
            generate(st,open,close+1,n);
            st.deleteCharAt(st.length()-1);
        }
    }
}
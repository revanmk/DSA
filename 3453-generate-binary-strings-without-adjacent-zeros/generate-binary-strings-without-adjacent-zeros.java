class Solution {
    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        generate(n,new StringBuilder(),ans);
        return ans;
    }
    public static void generate(int n,StringBuilder current,List<String> ans)
    {
        if(current.length()==n)
        {
            ans.add(current.toString());
            return;
        }
        if(current.length()==0||current.charAt(current.length()-1)!='0'){
            current.append("0");
            generate(n,current,ans);
            current.deleteCharAt(current.length()-1);
        }
        current.append('1');
            generate(n,current,ans);
            current.deleteCharAt(current.length()-1);
    }
}
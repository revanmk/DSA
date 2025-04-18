class Solution {
    public String countAndSay(int n) {
        String a="1";
        for(int i=1;i<n;i++)
        {
            a=RLE(a);
        }
        return a;
    }
    public String RLE(String s){
        StringBuilder ans=new StringBuilder();
        int cnt=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))
                cnt++;
            else{
                ans.append(cnt).append(s.charAt(i-1));
                cnt=1;
            }
        }
        ans.append(cnt).append(s.charAt(s.length()-1));
        return ans.toString();
    }
}
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            int p1=i;
            int p2=i;
            while(p1>=0 && p2<n && s.charAt(p1)==s.charAt(p2)){
                p1--;
                p2++;
            }
            if(p2-p1-1>maxLen){
                maxLen=p2-p1-1;
                ans=s.substring(p1+1,p2);
            }
            p1=i;
            p2=i+1;
            while(p1>=0 && p2<n && s.charAt(p1)==s.charAt(p2)){
                p1--;
                p2++;
            }
            if(p2-p1-1>maxLen){
                maxLen=p2-p1-1;
                ans=s.substring(p1+1,p2);
            }

        }
        return ans;
    }
}
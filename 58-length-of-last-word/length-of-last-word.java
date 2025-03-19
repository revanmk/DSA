class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==1)
            return 1;
        int p=s.length()-1;
        while(p>=0 && s.charAt(p)==' ')
            p--;
        int cnt=0;
        while(p>=0 && s.charAt(p)!=' '){
            cnt++;
            p--;
        }
        return cnt;
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        int lps[]=new int[needle.length()];
        int l=0;
        int i=1;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(l))
            {
                l++;
                lps[i]=l;
                i++;
            }
            else{
                if(l!=0)
                {
                    l=lps[l-1];
                }
                else
                    i++;
            }
        }

        int a=0,b=0;
        while(b<haystack.length())
        {
            if(haystack.charAt(b)==needle.charAt(a)){
                a++;
                b++;
            }
            if(a==needle.length())
            {
                return b-a;
            }
            else if(b<haystack.length() && haystack.charAt(b)!=needle.charAt(a))
            {
                if(a!=0)
                {
                    a=lps[a-1];
                }
                else{
                    b++;
                }
            }
        }
        return -1;

    }
}
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt=0;
        for(int i=low;i<=high;i++)
        {
            if(check(Integer.toString(i)))
                cnt++;
        }
        return cnt;
    }
    public boolean check(String s){
        if(s.length()%2!=0)
            return false;
        int sum1=0,sum2=0;
        for(int i=0;i<s.length()/2;i++)
        {
            sum1+=s.charAt(i)-'0';        
        }
        for(int i=s.length()/2;i<s.length();i++)
        {
            sum2+=s.charAt(i)-'0';        
        }
        return sum1==sum2;
    }
}
class Solution {
    private static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int characters[]=new int[26];
        for(char ch:s.toCharArray())
        {
            ++characters[ch-'a'];
        }
        for(int ia=0;ia<t;++ia)
        {
            int alphabets[]=new int[26];
            alphabets[0]=characters[25];
            alphabets[1]=(characters[0]+characters[25])%MOD;
            for(int i=2;i<26;i++)
            {
                alphabets[i]=characters[i-1];
            }
            characters=alphabets;
        }
        
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + characters[i]) % MOD;
        }
        return ans;
        
    }
}

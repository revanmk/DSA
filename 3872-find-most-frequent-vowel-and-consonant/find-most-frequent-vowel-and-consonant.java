class Solution {
    public int maxFreqSum(String s) {
        int count[]=new int[26];
        Arrays.fill(count,0);
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']++;
        }
        int vowel=0;
        int consonent=0;
        for(int i=0;i<26;i++)
        {
            if(i==0 || i==4 || i==8 || i==14 || i==20)
                vowel=Math.max(vowel,count[i]);
            else
            consonent=Math.max(consonent,count[i]);
        }
        return vowel+consonent;
    }
}
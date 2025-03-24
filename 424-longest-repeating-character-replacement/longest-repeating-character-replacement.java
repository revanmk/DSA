class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxLength=0;
        int maxFreq=0;
        int count[]=new int[26];
        for(int right=0;right<s.length();right++)
        {
            count[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,count[s.charAt(right)-'A']);
            if((right-left+1-maxFreq)>k)
            {
                count[s.charAt(left)-'A']--;
                left++;            
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
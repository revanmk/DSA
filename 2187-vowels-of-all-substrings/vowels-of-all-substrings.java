class Solution {
    public long countVowels(String word) {
        boolean[] vowel = new boolean[128];
        vowel['a']=vowel['e']=vowel['i']=vowel['o']=vowel['u']=true;
        long prev=0;
        int curr=0;
        long ans=0;
        for(char ch : word.toCharArray()){
            curr++;
            if(vowel[ch]){
                ans+=prev+curr;
                prev+=curr;
            }
            else{
                ans+=prev;
            }
        }
        return ans;
    }
}
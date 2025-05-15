class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans=new ArrayList<>();
        int check=-1;
        for(int i=0;i<words.length;i++)
        {
            if(groups[i]!=check){
                ans.add(words[i]);
                check=groups[i];
            }
        }
        return ans;
    }
}
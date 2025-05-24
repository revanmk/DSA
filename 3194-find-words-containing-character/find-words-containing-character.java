class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int len=words[i].length();
            String str=words[i];
            for(int ik=0;ik<len;ik++)
            {
                if(str.charAt(ik)==x){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}
class Solution {
    private static final String[] KEYS={ "","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        List<String> ans=new LinkedList<String>();
        backtrack(digits,ans,0,"");
        return ans;
    }
    public void backtrack(String digits,List<String> ans,int ind,String pre){
        if(ind>=digits.length()){
            ans.add(pre);
            return;
        }
        String letters=KEYS[(digits.charAt(ind)-'0')];
        for(int i=0;i<letters.length();i++){
            backtrack(digits,ans,ind+1,pre+letters.charAt(i));
        }
    }
    
}
class Solution {
    public int possibleStringCount(String word) {
        int count[]=new int[26];
        int ans=1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i-1)==word.charAt(i)){
                ans++;
            }
        }
        return ans;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int len=s.length();
        int maxLen=0;
        while(right<len){
            int length=0;
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.get(s.charAt(right))>1){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            length=right-left+1;
            maxLen=Math.max(maxLen,length);
            right++;
        }
        return maxLen;
    }
}
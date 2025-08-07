class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        int left=0,right=0;
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char ch:t.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int len = s.length();
        int minLength = Integer.MAX_VALUE,start=0;
        HashMap<Character,Integer> map2 = new HashMap<>();
        int matched = 0;
        while(right<len){
            char r = s.charAt(right);
            map2.put(r,map2.getOrDefault(r,0)+1);

            if(map1.containsKey(r)  && map2.containsKey(r) && map2.get(r)<=map1.get(r)){
                matched++;
            }

            while(matched==t.length()){
                if(minLength>right-left+1){
                    minLength=right-left+1;
                    start = left;
                }
                char l = s.charAt(left);
                map2.put(l,map2.get(l)-1);
                if((map1.containsKey(l)  && map2.containsKey(l) && map2.get(l)<map1.get(l)))
                    matched--;
                left++;
            }
            right++;
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(start,start+minLength);
    }
}
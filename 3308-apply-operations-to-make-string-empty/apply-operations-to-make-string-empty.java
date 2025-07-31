class Solution {
    public String lastNonEmptyString(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        int maxLen = 0;
        for(Character ch : map.keySet()){
            maxLen = Math.max(maxLen,map.get(ch).size());
        }
        List<Character> maxChars = new ArrayList<>();
        HashMap<Character,Integer> lastIndex = new HashMap<>();
        for(Map.Entry<Character,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size()==maxLen){
                char ch = entry.getKey();
                maxChars.add(ch);
                lastIndex.put(ch,entry.getValue().get(entry.getValue().size()-1));
            }
        }
        maxChars.sort((a,b)->(lastIndex.get(a)-lastIndex.get(b)));
        StringBuilder sb = new StringBuilder();
        for (char ch : maxChars) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
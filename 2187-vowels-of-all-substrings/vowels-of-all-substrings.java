class Solution {
    public long countVowels(String word) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int len = word.length();
        long a=0;
        for(int i=0;i<len;i++){
            if(vowels.contains(word.charAt(i))){
                a+=(long)(i+1)*(len-i);
            }
        }
        return a;
    }
}
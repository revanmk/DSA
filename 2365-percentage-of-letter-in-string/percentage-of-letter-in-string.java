class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        char[] charArray = s.toCharArray();

        for(int i = 0; i <= charArray.length-1; i++){
            if(charArray[i] == letter){
                count += 1;
            }
        }

        int percent = (count * 100) / charArray.length;

        return percent;
    }

}
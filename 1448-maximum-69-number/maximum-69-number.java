class Solution {
    public int maximum69Number (int num) {
        StringBuilder s = new StringBuilder(String.valueOf(num));
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='6'){
                s.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(s.toString());
    }
}
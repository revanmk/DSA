class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        String target = sortBits(n);
        for(int i=0;i<32;i++){
            if(target.equals(sortBits(1<<i))){
                return true;
            }
        }
        return false;
    }
    public static String sortBits(int num){
        char arr[] = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
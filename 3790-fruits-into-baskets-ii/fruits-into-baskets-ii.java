class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int len = fruits.length;
        int ans = len;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(fruits[i]<=baskets[j]){
                    ans--;
                    baskets[j]=0;
                    break;
                }
            }
        }
        return ans;
    }
}
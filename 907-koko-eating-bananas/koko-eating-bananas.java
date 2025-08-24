class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int length = piles.length;
        for(int i=1;i<length;i++){
            max = Math.max(max,piles[i]);
        }
        int low = 0;
        int high = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(minTime(mid,piles)<=h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static int minTime(int mid, int[] piles){
        int ans = 0;
        for(int i=0;i<piles.length;i++){
            ans += Math.ceil((double)piles[i]/(double)mid);
        }
        return ans;
    }
}
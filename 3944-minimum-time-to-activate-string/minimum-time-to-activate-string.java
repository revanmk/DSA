class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = order.length;
        int low = 0;
        int high = n-1;
        int ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(valid(order,mid,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean valid(int[] order, int t, int k){
        int n = order.length;
        boolean isStar[] = new boolean[n];
        for(int i=0;i<=t;i++){
            isStar[order[i]] = true;
        }
        long len = 0;
        long alpha = 0;
        for(int i = 0; i<n; i++){
            if(!isStar[i]){
                alpha++;
            }else{
                len+= alpha*(alpha+1)/2;
                alpha=0;
            }
        }
        if(alpha>0){
            len+=(alpha*(alpha+1))/2;
        }
        long totalSubStrings = (long) n * (n+1) / 2;
        return totalSubStrings-len>=k;

    }
}
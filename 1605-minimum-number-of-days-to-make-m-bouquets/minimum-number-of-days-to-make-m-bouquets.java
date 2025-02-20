class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)
            return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++)
        {
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        while(low<=high){
            int mid=(low+high)/2;
             if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    static boolean isPossible(int arr[],int mid,int m ,int k){
        int cnt=0;
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=mid)
                cnt++;
            else{
                ans+=(cnt/k);
                cnt=0;
            }
        }
        ans+=(cnt/k);
        return ans>=m;
    }
}
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(isPossible(mid,weights)<=days)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
    static int isPossible(int cap,int weights[]){
        int days=1;
        int load=0;
       for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > cap) {
                days += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
       }
        return days;
    }
}
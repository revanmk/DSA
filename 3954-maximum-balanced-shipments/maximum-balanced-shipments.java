class Solution {
    public int maxBalancedShipments(int[] weight) {
        int ans=0;
        int len = weight.length;
        for(int i=0;i<len-1;i++){
            if(weight[i]>weight[i+1]){
                ans++;
                i++;
            }
        }
        return ans;
    }
}
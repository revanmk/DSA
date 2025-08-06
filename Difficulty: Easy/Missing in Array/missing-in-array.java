class Solution {
    int missingNum(int arr[]) {
        long ans=0;
        int max=0;
        for(int a:arr){
            ans+=a;
            max=Math.max(max,a);
        }
        long expected=(long)max*(max+1)/2;
        return ans==expected?max+1:(int)(expected-ans);
    }
}
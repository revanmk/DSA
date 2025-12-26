class Solution {
    public static int largest(int[] arr) {
        // code here
        int len =  arr.length;
        int ans = arr[0];
        for(int i=1;i<len;i++){
                if(arr[i]>ans){
                    ans=Math.max(ans,arr[i]);
                }
            }
        return ans;
    }
}

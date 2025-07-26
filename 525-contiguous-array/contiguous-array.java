class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len=nums.length;
        int ans=0;
        int max=0;
        map.put(0,-1);
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                ans-=1;
            }else{
                ans+=1;
            }
                if(map.containsKey(ans))
                    max=Math.max(max,i-map.get(ans));
                else
                    map.put(ans,i);
            
        }
        return max;
        
    }
}

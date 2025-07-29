class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int len = fronts.length;
        int ans1=Integer.MAX_VALUE;
        int ans2=Integer.MAX_VALUE;
        HashSet<Integer> invalid = new HashSet<>();
        for(int i=0;i<len;i++){
            if(fronts[i]==backs[i]){
                invalid.add(fronts[i]);
            }
        }
        for(int i=0;i<len;i++){
            if(!invalid.contains(fronts[i]))
            ans1=Math.min(ans1,fronts[i]);
            if(!invalid.contains(backs[i]))
            ans2=Math.min(ans2,backs[i]);
        }
        int res = Math.min(ans1,ans2);
        return res==Integer.MAX_VALUE?0:res;
    }
}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0,c2=0;
        int e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(c1 == 0 && e2!=nums[i]){
                c1 = 1;
                e1 = nums[i];
            }else if(c2 == 0 && e1!=nums[i]){
                c2 = 1;
                e2 = nums[i];
            }else if(nums[i] == e1){
                c1++;
            }else if(nums[i] == e2){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        int check = (int)(len/3)+1;
        int cnt1=0,cnt2=0;
        for(int i=0;i<len;i++){
            if(nums[i] == e1){
                cnt1++;
            }
            if(nums[i] == e2){
                cnt2++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(cnt1 >= check){
            ans.add(e1);
        }
        if(cnt2 >= check){
            ans.add(e2);
        }
        return ans;
    }
}
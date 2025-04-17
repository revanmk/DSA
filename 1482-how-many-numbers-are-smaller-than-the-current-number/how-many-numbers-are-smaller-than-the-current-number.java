// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int copy[]=nums.clone();
//         Arrays.sort(copy);
        
//         for (int i = 0; i < nums.length; i++) {
//             map.putIfAbsent(copy[i], i);
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             copy[i] = map.get(nums[i]);
//         }
//         return copy;
//     }
// }
//Using Count Array  TC:O(n)  SC:O(n)
class Solution{
    public int[] smallerNumbersThanCurrent(int[] nums){
        int count[]=new int[101];
        Arrays.fill(count,0);
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            count[nums[i]]++;
        }
        for(int i=1;i<101;i++)
        {
            count[i]+=count[i-1];
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
                ans[i]=0;
            else
            ans[i]=count[nums[i]-1];
        }
        return ans;
    }
}



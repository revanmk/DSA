/*BruteForce Approach  TC:O(n*n)  SC:O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=nums.length;i++)
        {
            boolean flag=false;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[j]==i){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                ans.add(i);
            }
        }
        return ans;
    }
}
*/

/* Using Set  TC:O(n)  SC:O(n)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i))
                result.add(i);
        }
        return result;
    }
}
*/
//Using Binary Search   TC:O(nlogn)  SC:O(n)
/*
class Solution{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1;i<=nums.length;i++)
        {
            if(!binarySearch(0,nums.length-1,i,nums))
                ans.add(i);
        }
        return ans;
    }
    public static boolean binarySearch(int low,int high,int target,int nums[]){
        while(low<=high){
        int mid=(low+high)/2;
        if(nums[mid]==target)
            return true;
        else if(nums[mid]<target)
            low=mid+1;
        else
            high=mid-1;
        }
        return false;
    }
}
*/
// //Swapping  TC:O(n)  SC:O(1)
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++) {
//             while (nums[i] != nums[nums[i] - 1]) {
//                 int temp = nums[i];
//                 nums[i] = nums[temp - 1];
//                 nums[temp - 1] = temp;
//             }
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != i + 1)
//                 ans.add(i + 1);
//         }
//         return ans;
//     }

// }
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0)
                ans.add(i + 1);
        }
        return ans;
    }

}

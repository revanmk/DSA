class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        int count = 0;
        for (int ele : nums) {
            if(ele>min && ele<max){
                count++;
            }
        }
        return count;
    }
}

/*

2 7 11 15
-71 -71 -71 40 93

*/
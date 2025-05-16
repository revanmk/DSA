class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int ans[]=new int[len];
        Stack<Integer> st=new Stack<>();
        int ind=0;
        Arrays.fill(ans,-1);
        for(int i=0;i<len*2;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i%len])
                ans[st.pop()]=nums[i%len];
            st.push(i%len);
        }
        return ans;
    }
}
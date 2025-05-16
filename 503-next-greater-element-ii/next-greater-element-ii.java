class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int ans[]=new int[len];
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=(len*2)-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums[i%len])
                st.pop();
            if(i<len && !st.isEmpty())
                ans[i]=st.peek();
            st.push(nums[i%len]);
        }
        return ans;
    }
}
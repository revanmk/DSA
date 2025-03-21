class Solution {
    public int maxArea(int[] height) {
        int area=Integer.MIN_VALUE;
        int left=0;
        int right=height.length-1;
        while(left<right)
        {
            int temp=Math.min(height[left],height[right]);
            int len=right-left;
            area=Math.max(area,(temp*len));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return area;
    }
}
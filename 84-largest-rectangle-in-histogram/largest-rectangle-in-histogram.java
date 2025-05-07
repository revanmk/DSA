import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nextSmaller = nextSmallerElements(heights);
        int[] prevSmaller = prevSmallerElements(heights);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int[] prevSmallerElements(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] prev = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return prev;
    }

    public static int[] nextSmallerElements(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] next = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);
        }

        return next;
    }
}

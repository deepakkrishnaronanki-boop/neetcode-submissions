class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();

        int maxArea = 0, n = heights.length;

        for (int i = 0; i < n; i++) {
            int index = i;
            while (!stack.isEmpty() && heights[i] <= stack.peek()[0]) {
                int[] height = stack.pop();
                index = height[1];
                int area = (i - index) * height[0];
                maxArea = Math.max(area, maxArea);
            }

            stack.push(new int[] {heights[i], index});
        }

        for(int[] height : stack) {
            int area = (n - height[1]) * height[0];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}

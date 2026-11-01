class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();

        int maxArea = 0, n = heights.length;

        for(int i = 0; i < n; i++) {
            int index = i;

            while(!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                int[] bar = stack.pop();
                index = bar[1];
                maxArea = Math.max(maxArea, (i - index) * bar[0]);
            }

            stack.push(new int[]{heights[i], index});
        }

        while(!stack.isEmpty()) {
            int[] bar = stack.pop();

            maxArea = Math.max(maxArea, (n - bar[1]) * bar[0]);
        }

        return maxArea;
    }
}

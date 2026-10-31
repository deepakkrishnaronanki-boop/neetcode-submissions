class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0, r = heights.length - 1, maximum = 0;

        while(l < r) {

            int water = Math.min(heights[l], heights[r]) * (r - l);

            maximum = Math.max(water, maximum);

            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maximum;
    }
}

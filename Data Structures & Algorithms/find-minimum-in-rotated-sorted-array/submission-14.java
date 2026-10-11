class Solution {
    public int findMin(int[] nums) {
        
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(l <= r) {
            if(nums[l] < nums[r]) return Math.min(nums[l], min);

            int m = l + (r - l) / 2;
            min = Math.min(nums[m], min);

            if(nums[m] < nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return min;
    }
}

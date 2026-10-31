class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, sum = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            }

            r++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
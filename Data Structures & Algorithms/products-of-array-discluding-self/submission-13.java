class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1, n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        prefix = 1;

        for (int j = n - 1; j >= 0; j--) {
            res[j] = res[j] * prefix;
            prefix *= nums[j];
        }

        return res;
    }
}

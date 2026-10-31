class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int prefix = 1, n = nums.length, i = 0;
        int[] res = new int[n];

        for(int num : nums) {
            res[i++] = prefix;
            prefix *= num;
        }

        prefix = 1;

        for(int j = n - 1; j >=0;j--) {
            
            res[j] = res[j] * prefix;
            prefix *= nums[j];
        }

        return res;

    }
}  

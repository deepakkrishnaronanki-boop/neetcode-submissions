class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length, prefix = 1;
        int[] res = new int[n];

        for(int i = 0;i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;

        for(int i = nums.length-1;i >=0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}  

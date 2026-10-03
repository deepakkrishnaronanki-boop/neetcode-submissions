class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i = 0, n = nums.length;

        while (i < n) {
            if(nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }

            int index = nums[i] - 1;

            if(nums[i] != nums[index]) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            } else {
                i++;
            }
        }

        i = 1;

        for(int num : nums) {
            if(num != i) return i;
            i++;
        }
        return n+1;
    }
}
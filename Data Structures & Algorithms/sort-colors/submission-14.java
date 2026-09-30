class Solution {
    public void sortColors(int[] nums) {
        
        int l = 0, i = 0, r = nums.length-1;


        while(i <= r) {
            if(nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else if(nums[i] == 0) {
                swap(nums, i, l);
                l++;
                i++;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
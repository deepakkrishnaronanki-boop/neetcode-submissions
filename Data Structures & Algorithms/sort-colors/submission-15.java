class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, i = 0;

        while (l <= r) {
            if(nums[l] == 0){
                swap(nums, l, i);
                i++;
                l++;
            } else if(nums[l] == 2){
                swap(nums, r, l);
                r--;
            } else {
                l++;
            }
        }
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
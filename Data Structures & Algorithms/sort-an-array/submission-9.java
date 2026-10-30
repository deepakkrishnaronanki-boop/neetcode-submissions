class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        if(n <= 1) return nums;

        int m = n / 2;

        int[] left = new int[m];
        int[] right = new int[n - m];

        for(int i = 0; i<m; i++){
            left[i]= nums[i];
        }

        for(int i = m; i < n; i++) {
            right[i-m] = nums[i];
        }

        sortArray(left);
        sortArray(right);
        return merge(left, right, nums);
    }

    private int[] merge(int[] left, int[] right, int[] nums) {
        int l = 0, r = 0, k = 0;

        while(l < left.length && r < right.length) {
            if(left[l] <= right[r]) {
                nums[k++] = left[l++];
            } else {
                nums[k++] = right[r++];
            }
        }

        while(l < left.length) {
            nums[k++] = left[l++];
        }

        while(r < right.length) {
            nums[k++] = right[r++];
        }

        return nums;
    }
}
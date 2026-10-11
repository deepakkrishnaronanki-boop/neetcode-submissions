class Solution {
    public int splitArray(int[] nums, int k) {
        
        int l = 0, r = 0;

        for(int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int noOfsubArrays = split(nums, mid);

            if(noOfsubArrays <= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }

    private int split(int[] nums, int capacity) {

        int subArrays = 0, sum = 0;

        for(int num : nums) {
            sum += num;
            if(sum == capacity) {
                subArrays++;
                sum = 0;
            } else if(sum > capacity) {
                subArrays++;
                sum = num;
            }
        }

        return sum == 0 ? subArrays : 1 + subArrays;
    }
}
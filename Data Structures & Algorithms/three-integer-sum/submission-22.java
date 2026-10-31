class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i < nums.length - 1; i++) {

            if(nums[i] > 0) return res;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i+1, r = nums.length-1;

            while(l < r) {
                if(l > i+1 && nums[l] == nums[l-1]) {
                    l++;
                    continue;
                }

                if(r < nums.length-1 && nums[r] == nums[r+1]) {
                    r--;
                    continue;
                }

                int sum = nums[l] + nums[r] + nums[i];

                if(sum == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if(sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;
    }
}

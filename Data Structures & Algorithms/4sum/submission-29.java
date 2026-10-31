class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2;i++) {

            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j = i+1; j < nums.length-1;j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int l = j + 1, r = nums.length-1;

                while(l < r) {
                    if(l > j+1 && nums[l] == nums[l-1]) {
                        l++;
                        continue;
                    } 

                    if(r < nums.length-1 && nums[r] == nums[r+1]) {
                        r--;
                        continue;
                    }

                    double sum = (double) nums[i] + nums[j] + nums[l] + nums[r];

                    if(sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if(sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
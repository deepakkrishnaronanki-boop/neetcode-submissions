class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, subset, new boolean[nums.length]);
        return res;
    }


    private void dfs(int[] nums, List<Integer> subset, boolean[] pick) {
        if(subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i = 0;i < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i-1] && !pick[i-1]) continue;

            if(!pick[i]) {
                subset.add(nums[i]);
                pick[i] = true;
                dfs(nums, subset, pick);
                subset.remove(subset.size() - 1);
                pick[i] = false;
            }
        }
    }
}
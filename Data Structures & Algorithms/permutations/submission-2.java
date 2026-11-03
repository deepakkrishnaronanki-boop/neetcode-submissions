class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, subset, new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<Integer> subset, boolean[] pick) {
        if(subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
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

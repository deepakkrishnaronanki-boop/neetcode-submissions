class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, 0, target, res, subset);

        return res;
    }

    private void dfs(int[] nums, int start,int sum, int target, List<List<Integer>> res, List<Integer> subset) {

        if(sum == target) {
            res.add(new ArrayList<>(subset));
        }

        if(sum > target) return;

        for(int i = start;i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i, sum + nums[i], target, res, subset);
            subset.remove(subset.size()-1);
        }

        
    }
}

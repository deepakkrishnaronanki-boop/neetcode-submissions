class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, subset);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> subset) {
        if(start == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }


        subset.add(nums[start]);
        dfs(nums, start + 1, subset);
        subset.remove(subset.size() - 1);

        while(start+1 < nums.length && nums[start] == nums[start+1]) {
            start++;
        }
        dfs(nums, start + 1, subset);
    }
}

class Solution {

    List<List<Integer>> res;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        this.target = target;
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, combination);

        return res;
    }

    private void dfs(int[] candidates, int start, int sum, List<Integer> combination) {
        if(sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if(sum > target) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            combination.add(candidates[i]);
            dfs(candidates, i+1, sum + candidates[i], combination);
            combination.remove(combination.size() - 1);
        }
    }
}

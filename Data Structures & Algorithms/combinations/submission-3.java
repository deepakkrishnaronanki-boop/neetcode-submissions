class Solution {
    List<List<Integer>> res;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        
        res = new ArrayList<>();
        this.k = k;

        List<Integer> combination = new ArrayList<>();

        dfs(n, 1, combination);
        return res;
    }

    private void dfs(int n, int start, List<Integer> combination) {
        if(combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if(start > n) return;

        combination.add(start);
        dfs(n, start +1, combination);
        combination.remove(combination.size() - 1);
        dfs(n, start + 1, combination);
    }
}
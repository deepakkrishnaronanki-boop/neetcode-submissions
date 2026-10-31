class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int streak = 0;
        Map<Integer, Integer> lookup = new HashMap<>();

        lookup.put(0, 1);
        int sum = 0, res = 0;
        for(int num : nums) {
            sum += num;

            int diff = sum - k;

            if(lookup.containsKey(diff)) {
                res += lookup.get(diff);
            }

            lookup.put(sum, lookup.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
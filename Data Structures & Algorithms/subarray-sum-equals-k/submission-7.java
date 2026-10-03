class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> lookup = new HashMap<>();

        int sum = 0, res = 0;

        lookup.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int diff = sum - k;
            
            if(lookup.containsKey(diff)) {
                res += lookup.get(diff);
            }

            lookup.put(sum, lookup.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
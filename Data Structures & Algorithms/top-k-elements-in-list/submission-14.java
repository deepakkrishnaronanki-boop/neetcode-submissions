class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] buckets = new List[n + 1];

        for(int i = 0;i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length-1;i >= 0; i--) {

            for(int num : buckets[i]) {
                res[index++] = num;
                if(index == k) return res;
            }

        }

        return res;
    }
}

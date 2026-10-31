class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List[] bucket = new List[nums.length + 1];

        for(int i = 0;i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];

        int index = 0;

        for(int i = bucket.length-1; i >=0; i--) {
            List<Integer> list = bucket[i];

            for(int num : list) {
                res[index++] = num;
                if(index == k) return res;
            }
        }

        return res;
    }
}

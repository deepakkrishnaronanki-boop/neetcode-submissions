class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> lookup = new HashSet<>();

        for (int num : nums) {
            lookup.add(num);
        }

        int res = 0;

        for (int num : nums) {
            if (lookup.contains(num - 1))
                continue;

            int count = 1;

            while (lookup.contains(num + 1)) {
                count++;
                num++;
            }

            res = Math.max(res, count);
        }
        return res;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> copy = new HashSet<>();

        for(int i : nums) {
            copy.add(i);
        }

        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(copy.contains(num - 1)) continue;

            int count = 0;
            while(copy.contains(num)) {
                count++;
                num++;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}

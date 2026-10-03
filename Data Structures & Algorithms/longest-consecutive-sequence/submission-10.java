class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> copy = new HashSet<>();

        for(int i : nums) {
            copy.add(i);
        }

        int res = 0;

        for(int num : copy) {
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

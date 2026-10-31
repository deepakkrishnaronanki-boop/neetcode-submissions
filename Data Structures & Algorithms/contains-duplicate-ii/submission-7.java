class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> lookup = new HashSet<>();

        int l = 0;

        for(int r = 0; r < nums.length; r++) {
            if(r - l > k) {
                lookup.remove(nums[l++]);
            }

            if(!lookup.add(nums[r])) return true;
        }

        return false;
    }
}
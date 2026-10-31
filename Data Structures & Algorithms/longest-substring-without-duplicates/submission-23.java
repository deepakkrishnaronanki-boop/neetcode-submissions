class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int res = 0, l = 0, r = 0;
        int[] arr = new int[256];

        while(r < s.length()) {

            arr[s.charAt(r)]++;

            while(l < r && arr[s.charAt(r)] > 1) {
                arr[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}

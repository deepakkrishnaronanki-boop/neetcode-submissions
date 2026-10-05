class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> freq = new HashMap<>();

        int maxCount = 0, l = 0, r = 0, maxLen = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            maxCount = Math.max(maxCount, freq.get(c));

            if((r-l+1) - maxCount > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}

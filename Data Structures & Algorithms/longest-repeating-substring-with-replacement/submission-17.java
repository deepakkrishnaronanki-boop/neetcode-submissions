class Solution {
    public int characterReplacement(String s, int k) {
        
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int count = 0, res = 0, l = 0;
        for(int i = 0; i < s.length(); i++) {
            
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);

            count = Math.max(freq.get(s.charAt(i)), count);

            if(((i-l+1) - count) > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}

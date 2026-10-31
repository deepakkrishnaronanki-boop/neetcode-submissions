class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i = 0;i < s1.length();i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        for(int r = 0;r < s2.length();r++) {
            s2Arr[s2.charAt(r) - 'a']++;

            if(r - l + 1 > s1.length()) {
                s2Arr[s2.charAt(l++) - 'a']--;
            }

            if(Arrays.equals(s1Arr, s2Arr)) return true;
        }

        return false;
    }
}
